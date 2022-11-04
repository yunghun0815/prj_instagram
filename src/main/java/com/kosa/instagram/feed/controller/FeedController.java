package com.kosa.instagram.feed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.instagram.JsonVo;
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
	
	@RequestMapping("/mainfeed/test")
	public @ResponseBody List<JsonVo> getTenFeeds(@PathVariable String memberId, @PathVariable int page) {
		List<JsonVo> jsonList = new ArrayList<JsonVo>();
		int start = page*10+1;
		int end = start+9;
		List<FeedVo> feedList = feedService.getTenFeeds(memberId, start, end);
		for(FeedVo feed : feedList) {
			jsonList.add(feedService.makeJsonVo(feed));
		}
		return jsonList;
	}
}