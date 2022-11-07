package com.kosa.instagram.feed.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.service.IFeedService;
import com.kosa.instagram.member.model.MemberVo;


@Controller
public class FeedController {

	@Autowired
	IFeedService feedService;
	
	@RequestMapping("/userfeed/{memberId}")
	public String getUserFeed(@PathVariable String memberId,Model model ) {
		int contentCount=feedService.countContent(memberId);
		int followerCount=feedService.countFollowerByUser(memberId);
		int followCount=feedService.countFollowByUser(memberId);
		model.addAttribute("memberId",memberId);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followCount",followCount);
		model.addAttribute("contentCount",contentCount);
		
		return "feed/userfeed";
	}
	

	//@RequestMapping("/memberlist")
	@RequestMapping(value="memberlist", method=RequestMethod.POST)
	//public String getMemberList(String keyword, Model model ) {
	public String getMemberList(String keyword, HttpSession session, Model model) {
		
		// ���� DB�� �����ϱ� �ϴ� �ӽ÷� ������
		List<MemberVo> memberList = feedService.searchListByKeyword(keyword);  
		model.addAttribute("memberList", memberList); 
		  
		model.addAttribute("attribute1", "Hello world");
		
		return "feed/search"; 
	}
}
	
	
	
	
