package com.kosa.instagram.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
		
		return "/feed/userfeed";
	}
	
	@RequestMapping(value="/writefeed/{memberId}",method=RequestMethod.GET)
	public String insertFeed(FileVo file,@PathVariable String memberId,Model model ) {
		model.addAttribute("memberId",memberId);
		System.out.println(memberId);
		return "feed/writefeed";
	}
	
	@RequestMapping(value="/writefeed/{memberId}",method=RequestMethod.POST)
	public String writefeed(List<MultipartFile> fileList,HttpServletRequest req,Model model,FileVo file) {


		FeedVo feed=new FeedVo();
		String feedContent=req.getParameter("feedContent");
		String placeTitle=req.getParameter("placeTitle");
		String placeDetail=req.getParameter("placeDetail");
		String memberId=req.getParameter("memberId");
		feed.setFeedContent(feedContent);
		feed.setPlaceTitle(placeTitle);
		feed.setPlaceDetail(placeDetail);
		feed.setMemberId(memberId);
		
		String[] list=req.getParameterValues("hashtag[]");
		System.out.println(list);
		
	
		
		int check=feedService.checkPlace(placeDetail); //등록된 장소가 있는지 없는지
		System.out.println(check);
		if(check==0) { //등록장소가 없으면
			feedService.insertFeedPlace(feed); //장소등록
		}
		
		

		feedService.insertFeedContent(feed); //피드 등록

		try {
		for(MultipartFile mf: fileList) {
			
			int seqnum=(feedService.selectSeqNum())-1;
			
			
			file.setFeedNo(seqnum);
			file.setFileName(mf.getOriginalFilename());
			file.setFileSize(mf.getSize());
			file.setFileType(mf.getContentType());
			file.setFileData(mf.getBytes());
			file.setMemberId(memberId);
			
			System.out.println(memberId);
			System.out.println("시퀀스num: "+seqnum);
			System.out.println("파일이름: " +mf.getOriginalFilename());
			System.out.println("파일사이즈: "+mf.getSize());
			System.out.println("파일타입: "+mf.getContentType());
			
			feedService.insertFeedData(file);  //피드에 등록한 사진  db에 insert
			System.out.println("성공>o<");
			
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
			
		}
		
		return "redirect:/userfeed/"+feed.getMemberId();
		
	}
	

			
			
			
		
		}
			
					
		
		
		
		
	
	
