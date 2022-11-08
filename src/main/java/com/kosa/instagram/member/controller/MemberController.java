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

	//�쉶�썝媛��엯
	@RequestMapping(value="/member/insert", method=RequestMethod.GET)
	public String joinForm() {
		return "member/form";
	};

	//�쉶�썝媛��엯
	@RequestMapping(value="/member/insert", method=RequestMethod.POST)
	public String memberInsert(MemberVo member, HttpSession session) {
		System.out.println("CONTROLLER");
		System.out.println(member.toString());
		memberService.insertMember(member);

		return "home";
	}

	//濡쒓렇�씤
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	//濡쒓렇�씤
	@RequestMapping(value="member/login", method=RequestMethod.POST)
	public String login(String memberId, String password, HttpSession session, Model model) {
		MemberVo member = memberService.selectMember(memberId);
		if (member != null) {
			System.out.println("�븘�씠�뵒 �엳�쓬");
			String dbPassword = member.getPassword();
			if (dbPassword==null) {
				System.out.println("鍮꾨�踰덊샇 ��由�");
				model.addAttribute("message", "NOT_VALID_MEMBER");
			}else {
				System.out.println("媛숈쓬");
				if (dbPassword.equals(password)) {
					//占쏙옙橘占싫� 占쏙옙치
					session.setAttribute("memberId", memberId);
					session.setAttribute("name", member.getName());
					session.setAttribute("nickname", member.getNickname());
					session.setAttribute("fileNo", member.getFileNo());
					return "member/login";
				}else {
					//占쏙옙橘占싫� 占쏙옙占쏙옙치
					model.addAttribute("message", "WRONG_PASSOWRD");
				}
			}
		}else {
			model.addAttribute("message", "USER_NOT_FOUND");
		}
		session.invalidate();
		return "member/login";
	}
	//濡쒓렇�븘�썐
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return "home";
	}
		//�닔�젙 �럹�씠吏� 鍮꾨�踰덊샇濡� �젙蹂� �솗�씤
	   @GetMapping("/member/check")
	   public String check() {
	      return "member/check";
	   }
	   @PostMapping("/member/check")
	   public String checkPassword(String password, HttpSession session, Model model) {
	      //濡쒓렇�씤
	      String memberId = (String)session.getAttribute("memberId");
	      MemberVo member = memberService.selectMember(memberId);
	      if(password.equals(member.getPassword())) {
	         return "redirect:/member/update";
	      }else {
	         model.addAttribute("message", "鍮꾨�踰덊샇媛� ���졇�뒿�땲�떎");
	         return "redirect:/member/check";
	      }
	   }
	
	//�쉶�썝�젙蹂� �닔�젙
	@RequestMapping(value="/member/update", method=RequestMethod.GET)
	public String updateMember(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		if (memberId != null && !memberId.equals("")) {
			MemberVo member = memberService.selectMember(memberId);
			
			model.addAttribute("member", member);
			model.addAttribute("message", "UPDATE_USER_INFO");
			//fileNo 議고쉶
			model.addAttribute("fileNo", memberService.selectFileNo(memberId));
		}else {
			//memberId媛� �꽭�뀡�뿉 �뾾�쓣 �뻹 (濡쒓렇�씤 �븯吏� �븡�븯�쓣 �븣)
			model.addAttribute("message", "NOT_LOGIN_USER");
			return "member/login";
		}
		return "member/update";
	}
	@RequestMapping(value="/member/update", method=RequestMethod.POST)
	public String updateMember(MemberVo member, FileVo file ,HttpSession session, Model model) {
	try {
		MultipartFile mfile = file.getFile();
		logger.info("�뙆�씪 : "+mfile);
		if (mfile != null && !mfile.isEmpty()) {
			file.setFileName(mfile.getOriginalFilename());
			file.setFileSize(mfile.getSize());
			file.setFileType(mfile.getContentType());
			file.setFileData(mfile.getBytes());
			logger.info("/board/write : " + file.toString());
			
			memberService.updateMember(member, file);
		}else {
			logger.info("�뙆�씪 �븞�뱾�뼱�샂");
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
			System.out.println("delete �븘�씠�뵒 �뾾�쓬");
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
			System.out.println("�깉�눜 鍮꾨�踰덊샇 遺덉씪移�");
			return "member/delete";
		}
	}


}//class end