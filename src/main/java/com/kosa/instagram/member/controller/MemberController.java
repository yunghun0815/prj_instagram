package com.kosa.instagram.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.member.model.MemberVo;
import com.kosa.instagram.member.service.IMemberService;

@Controller
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	IMemberService memberService;

	//회원가입
	@RequestMapping(value="/member/insert", method=RequestMethod.GET)
	public String joinForm() {
		return "member/form";
	};

	//회원가입
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public String memberInsert(MemberVo member, HttpSession session) {
		System.out.println("CONTROLLER");
		System.out.println(member.toString());
		memberService.insertMember(member);

		return "home";
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
			System.out.println("아이디 있음");
			String dbPassword = member.getPassword();
			if (dbPassword==null) {
				System.out.println("비밀번호 틀림");
				model.addAttribute("message", "NOT_VALID_MEMBER");
			}else {
				System.out.println("같음");
				if (dbPassword.equals(password)) {
					//��й�ȣ ��ġ
					session.setAttribute("memberId", memberId);
					session.setAttribute("name", member.getName());
					session.setAttribute("nickname", member.getNickname());
					session.setAttribute("fileData", member.getFileData());
					return "member/login";
				}else {
					//��й�ȣ ����ġ
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
		return "home";
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
	public String updateMember(MemberVo member, FileVo file ,HttpSession session, Model model) {
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
	return "member/login";
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


}//class end
