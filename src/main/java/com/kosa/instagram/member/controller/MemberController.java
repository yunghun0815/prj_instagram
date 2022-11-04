package com.kosa.instagram.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//회원가입 저장
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
			System.out.println("아이디 입력됨");
			String dbPassword = member.getPassword();
			if (dbPassword==null) {
				//아이디가 없음
				System.out.println("아이디 없음");
				model.addAttribute("message", "NOT_VALID_MEMBER");
			}else {
				//아이디 있음
				System.out.println("아이디 있음");
				if (dbPassword.equals(password)) {
					//비밀번호 일치
					System.out.println("비밀번호 일치");
					session.setAttribute("memberId", memberId);
					session.setAttribute("name", member.getName());
					session.setAttribute("nickname", member.getNickname());
					session.setAttribute("fileData", member.getFileData());
					return "member/login";
				}else {
					//비밀번호 불일치
					System.out.println("비밀번호 불일치");
					model.addAttribute("message", "WRONG_PASSOWRD");
				}
			}
		}else {
			model.addAttribute("message", "USER_NOT_FOUND");
		}
		session.invalidate();
		return "member/login";
	}
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return "home";
	}
	
}//class end
