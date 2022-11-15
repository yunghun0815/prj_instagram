package com.kosa.instagram.member.controller;

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
	public String login() {
		return "member/login";
	}

	//로그인
	@RequestMapping(value="member/login", method=RequestMethod.POST)
	public String login(String memberId, String password, HttpSession session, Model model) {
		MemberVo member = memberService.selectMember(memberId);
		if (member != null) {
			System.out.println("아이디 o");
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
		String dbpw = memberService.getPassword(password);
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
		model.addAttribute("findMemberId", new MemberVo());
		return "member/findMemberId";
	}
	@RequestMapping(value="/member/findMemberId", method=RequestMethod.POST)
	public String findMemberId(@ModelAttribute("findMemberId") @Valid String email, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "member/findMemberId";
		}else {
			if (email != null && !email.equals("")) {
				MemberVo member = memberService.findMmeberId(email);
				if (member!=null) {
					model.addAttribute("member", member);
					//session.setAttribute("member", member);
					System.out.println("이메일 일치");
					//session.invalidate();
					return "/member/findMemberId";
				}else {
					System.out.println("가입된 회원정보가 없습니다.");
					return "/member/findMemberId";
				}
			}
			return "redirect:/member/login";
		}
	}
	@RequestMapping(value="/member/findPassword", method=RequestMethod.GET)
	public String findPassword() {
		return "member/findPassword";
	}

	@RequestMapping(value="/member/findPassword", method=RequestMethod.POST)
	public String findPassword(String memberId, String email, Model model ) {
		if (memberId !=null && !memberId.equals("")) {
			if (email != null && !email.equals("")) {
				MemberVo member = new MemberVo();
				member = memberService.findPassword(memberId, email);
				System.out.println("뭔가 입력되긴 함");
				//member가 null이 아니라는 건 email과 memberid가 맞게 들어갔다는 소리
				if (member != null) {
					model.addAttribute("memberId", member.getMemberId());
					model.addAttribute("password", member.getPassword());
					System.out.println("아이디 이메일 일치" + member.getPassword() + member.getMemberId());
					return "member/findPassword";
				}else {
					System.out.println("아이디와 이메일 일치 x");
					return "member/findPassword";
				}
			}
		}
		System.out.println("null 입력");
		return "redirect:/member/login";
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