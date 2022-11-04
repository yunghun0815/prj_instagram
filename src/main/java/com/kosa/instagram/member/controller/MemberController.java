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
	
	//ȸ������
	@RequestMapping(value="/member/insert", method=RequestMethod.GET)
	public String joinForm() {
		return "member/form";
	};
	
	//ȸ������ ����
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public String memberInsert(MemberVo member, HttpSession session) {
		System.out.println("CONTROLLER");
		System.out.println(member.toString());
		memberService.insertMember(member);
		
		return "home";
	}
	
	//�α���
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	//�α���
	@RequestMapping(value="member/login", method=RequestMethod.POST)
	public String login(String memberId, String password, HttpSession session, Model model) {
		MemberVo member = memberService.selectMember(memberId);
		if (member != null) {
			System.out.println("���̵� �Էµ�");
			String dbPassword = member.getPassword();
			if (dbPassword==null) {
				//���̵� ����
				System.out.println("���̵� ����");
				model.addAttribute("message", "NOT_VALID_MEMBER");
			}else {
				//���̵� ����
				System.out.println("���̵� ����");
				if (dbPassword.equals(password)) {
					//��й�ȣ ��ġ
					System.out.println("��й�ȣ ��ġ");
					session.setAttribute("memberId", memberId);
					session.setAttribute("name", member.getName());
					session.setAttribute("nickname", member.getNickname());
					session.setAttribute("fileData", member.getFileData());
					return "member/login";
				}else {
					//��й�ȣ ����ġ
					System.out.println("��й�ȣ ����ġ");
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
