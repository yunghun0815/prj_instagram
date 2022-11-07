package com.kosa.instagram.feed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.service.IFeedService;
import com.kosa.instagram.member.model.MemberVo;
import com.kosa.instagram.member.service.IMemberService;


@Controller
public class FeedController {

	@Autowired
	IFeedService feedService;
	
	@Autowired
	IMemberService memberService;
	
	@RequestMapping("/userfeed/{memberId}")
	public String getUserFeed(@PathVariable String memberId,Model model ) {
		int contentCount=feedService.countContent(memberId);
		int followerCount=feedService.countFollowerByUser(memberId);
		int followCount=feedService.countFollowByUser(memberId);
		model.addAttribute("memberId",memberId);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followCount",followCount);
		model.addAttribute("contentCount",contentCount);
		
		MemberVo member=memberService.selectFeedMemberInfo(memberId);
		model.addAttribute("nickname",member.getNickname());
		model.addAttribute("name",member.getName());
		
		List<FileVo> contentList=feedService.selectContentListByUser(memberId);
		model.addAttribute("contentList",contentList);
		
		
		List<MemberVo> followerList=memberService.selectFollowerByUser(memberId);
		model.addAttribute("followerList",followerList);
		List<MemberVo> followList=memberService.selectFollowByUser(memberId);
		model.addAttribute("followList",followList);
		
		return "feed/userfeed";
	}
	
	
}