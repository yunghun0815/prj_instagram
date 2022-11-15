package com.kosa.instagram.member.controller;

import java.net.http.HttpRequest;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.service.IFeedService;
import com.kosa.instagram.member.model.MemberVo;
import com.kosa.instagram.member.service.IMemberService;

import jdk.internal.org.jline.utils.Log;
import lombok.val;

@Controller
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	IMemberService memberService;


	//회원가입
	@RequestMapping(value="/member/insert", method=RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("member", new MemberVo());
		return "member/form";
	};

	//회원가입
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute("member") @Valid MemberVo member, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "member/form";
		}
		System.out.println("CONTROLLER");
		System.out.println(member.toString());
		memberService.insertMember(member);
		session.invalidate();
		return "redirect:/	";
	}

	//로그인
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		request.getAttribute("loginId");
		request.getAttribute("loginPw");
		logger.info((String) request.getAttribute("loginId"));
		return "member/login";
	}

	//로그인
	@RequestMapping(value="member/login", method=RequestMethod.POST)
	public String login(String memberId, String password, HttpSession session, HttpServletRequest request, Model model) {
		MemberVo member = memberService.selectMember(memberId);
		request.setAttribute("loginId", memberId);
		if (member != null) {
			System.out.println("아이디 o");
			request.setAttribute("loginPw", password);
			String dbPassword = member.getPassword();
			if (dbPassword==null) {
				System.out.println("비밀번호 입력 x");
				model.addAttribute("message", "NOT_VALID_MEMBER");
			}else {
				System.out.println("비밀번호 입력 o");
				if (dbPassword.equals(password)) {
					//비밀번호 같음
					session.setAttribute("memberId", memberId);
					session.setAttribute("name", member.getName());
					session.setAttribute("nickname", member.getNickname());
					session.setAttribute("fileNo", member.getFileNo());
					return "redirect:/";
				}else {
					model.addAttribute("message", "WRONG_PASSOWRD");
				}
			}
		}else {
			model.addAttribute("message", "USER_NOT_FOUND");
		}
		session.invalidate();
		return "member/login";
	}
	//로그아웃
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return "member/login";
	}
	//수정 페이지 비밀번호로 정보 확인
	@GetMapping("/member/check")
	public String check() {
		return "member/check";
	}
	@PostMapping("/member/check")
	public String checkPassword(String password, HttpSession session, Model model) {
		//로그인
		String memberId = (String)session.getAttribute("memberId");
		MemberVo member = memberService.selectMember(memberId);
		if(password.equals(member.getPassword())) {
			return "redirect:/member/update";
		}else {
			model.addAttribute("message", "비밀번호가 틀렸습니다");
			return "redirect:/member/check";
		}
	}

	//회원정보 수정
	@RequestMapping(value="/member/update", method=RequestMethod.GET)
	public String updateMember(HttpSession session, Model model) {
		model.addAttribute("memberUpdate",new MemberVo());
		String memberId = (String)session.getAttribute("memberId");
		if (memberId != null && !memberId.equals("")) {
			MemberVo member = memberService.selectMember(memberId);

			model.addAttribute("member", member);
			model.addAttribute("message", "UPDATE_USER_INFO");
			//fileNo 조회
			model.addAttribute("fileNo", memberService.selectFileNo(memberId));
		}else {
			//memberId가 세션에 없을 떄 (로그인 하지 않았을 때)
			model.addAttribute("message", "NOT_LOGIN_USER");
			return "member/login";
		}
		return "member/update";
	}
	@RequestMapping(value="/member/update", method=RequestMethod.POST)
	public String updateMember(@ModelAttribute("memberUpdate") @Valid MemberVo member, BindingResult result, FileVo file ,HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "member/update";
		}else {
			try {
				MultipartFile mfile = file.getFile();
				logger.info("파일 : "+mfile);
				if (mfile != null && !mfile.isEmpty()) {
					file.setFileName(mfile.getOriginalFilename());
					file.setFileSize(mfile.getSize());
					file.setFileType(mfile.getContentType());
					file.setFileData(mfile.getBytes());
					logger.info("/board/write : " + file.toString());

					memberService.updateMember(member, file);
				}else {
					logger.info("파일 안들어옴");
					memberService.updateMember(member);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			session.invalidate();
			return "redirect:/member/login";
		}
	}

	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String deleteMember(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		if (memberId != null && !memberId.equals("")) {
			MemberVo member = memberService.selectMember(memberId);
			model.addAttribute("member", member);
			return "member/delete";
		}else {
			System.out.println("delete 아이디 없음");
			return "member/login";
		}
	}
	@RequestMapping(value="/member/delete", method=RequestMethod.POST)
	public String deleteMember(String password, HttpSession session, Model model) {
		MemberVo member = new MemberVo();
		member.setMemberId((String)session.getAttribute("memberId"));
		String dbpw = memberService.getPassword(member.getMemberId());
		if (password != null && password.equals(dbpw)) {
			member.setPassword(password);
			memberService.deleteMember(member);
			session.invalidate();
			return "member/login";
		}else {
			System.out.println("탈퇴 비밀번호 불일치");
			return "member/delete";
		}

	}
	@RequestMapping(value="/member/findMemberId", method=RequestMethod.GET)
	public String findMemberId(Model model) {
		return "member/findMemberId";
	}
	@ResponseBody
	@RequestMapping(value="/member/findMemberId", method=RequestMethod.POST)
	public String findMemberId(String email, HttpSession session, Model model) {
		String member = "1";
		if (email != null && !email.equals("")) {
			member = memberService.findMmeberId(email);
//			System.out.println("email :" + email);
//			System.out.println("member :" + member);
			return member;
		}
		return member;
	}
	@ResponseBody
	@RequestMapping(value="/member/findPassword", method=RequestMethod.POST)
	public String findPassword(String memberId, String email, Model model ) {
		String member = "1";
		System.out.println("확인 중입니다");
		if (memberId !=null && !memberId.equals("")) {
			member = memberService.findPassword(memberId, email);
			System.out.println("memberId : " + memberId);
			System.out.println("email : " + email);
			System.out.println("member :" +member);
			return member;
		}
		return member;
	}

	//id중복체크
	//RequestMapping 와responseBody를 같이 써주면 
	//return의 string이 .jsp를 반환하지 않고 문자열 그 자체를 반환하게 된다
	@ResponseBody
	@RequestMapping(value="/member/checkId")
	public String checkId(String memberId) { //유저가 입력한 값을 매개변수로 한다
		int idCheck = 0;
		try {
			//
			String result = memberService.checkId(memberId);
			//아이디가 있는 경우
			if (memberId != null && !memberId.equals("")) {
				if (result != null) {
					System.out.println("같은 아이디 있음");
					idCheck = 0;
				}else {
					System.out.println("같은 아이디 없음");
					idCheck = 1;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return idCheck + "";
	}
	@ResponseBody
	@RequestMapping(value="/member/checkNickname")
	public String checkNickname(String nickname) {
		int nicknameCheck = 0;
		String result = memberService.checkNickname(nickname);
		if (nickname != null && !nickname.equals("")) {
			try {
				if (result !=null) {
					System.out.println("같은 닉네임 있음");
					nicknameCheck = 0;
				}else {
					System.out.println("같은 닉네임 없음");
					nicknameCheck = 1;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return  nicknameCheck + "";
	}
	@ResponseBody
	@RequestMapping(value="/member/checkEmail")
	public String checkEmail(String email) {
		int emailCheck = 0;
		String result = memberService.checkEmail(email);
		if (email != null && !email.equals("")) {
			try {
				if (result != null) {
					System.out.println("같은 이메일 o");
					emailCheck = 0;
				}else {
					System.out.println("같은 이메일 x");
					emailCheck = 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emailCheck +"";
	}
	@RequestMapping("/follow/{toId}")
	public @ResponseBody void followMember(@PathVariable String toId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String fromId = (String)session.getAttribute("memberId");
		memberService.followMember(fromId, toId);
	}
	
	@RequestMapping("/unfollow/{toId}")
	public @ResponseBody void unfollowMember(@PathVariable String toId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String fromId = (String)session.getAttribute("memberId");
		memberService.unfollowMember(fromId, toId);
	}

	@RequestMapping("/isfollowing/{toId}")
	public @ResponseBody boolean isFollowing(@PathVariable String toId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String fromId = (String)session.getAttribute("memberId");
		List<String> followList = memberService.selectFollowByUser(fromId);
		for(String followId : followList) {
			if(followId.equals(toId)) {
				return true;
			}
		}
		return false;
	}
}//class end

