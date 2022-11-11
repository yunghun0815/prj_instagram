package com.kosa.instagram.feed.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.feed.service.IFeedService;
import com.kosa.instagram.member.model.MemberVo;


@Controller
public class FeedController {

	@Autowired
	IFeedService feedService;
	
	@RequestMapping("/userfeed/{memberId}")// ㅛㅜ정
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
	
	@GetMapping("/file/{fileNo}")
	public ResponseEntity<byte[]> getFile(@PathVariable int fileNo){
		try {
			if(fileNo != 0) {
				FileVo file = feedService.getFile(fileNo);
				
				HttpHeaders headers = new HttpHeaders();
				String[] mtypes = file.getFileType().split("/");
				headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
				headers.setContentLength(file.getFileSize());
				
			
				String fileName = new String(file.getFileName().getBytes("UTF-8"), "ISO-8859-1");
				headers.setContentDispositionFormData("attachment", fileName);
				return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
			}else {
				return null;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
			return null; 
		}
	}

	@RequestMapping("/mainfeed/{page}")
	public @ResponseBody List<JsonVo> getTenFeeds(@PathVariable int page, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		List<JsonVo> jsonList = new ArrayList<JsonVo>();
		int start = page*10+1;
		int end = start+9;
		List<FeedVo> feedList = feedService.getTenFeeds(memberId, start, end);
		for(FeedVo feed : feedList) {
			jsonList.add(feedService.makeJsonVo(feed, memberId));
		}
		return jsonList;
	}

	@RequestMapping(value="/writeReply/{feedNo}", method=RequestMethod.POST)
	public @ResponseBody List<ReplyVo> writeReply(@PathVariable int feedNo, @RequestParam String replyInput, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		feedService.writeReply(feedNo, memberId, replyInput);
		return feedService.getReply(feedNo);
	}
	
	@RequestMapping("/deleteReply/{feedNo}/{replyNo}")
	public @ResponseBody List<ReplyVo> deleteReply(@PathVariable int feedNo, @PathVariable int replyNo) {
		feedService.deleteReply(replyNo);
		return feedService.getReply(feedNo);
	}
	
	@RequestMapping("/increaseLike/{feedNo}")
	public @ResponseBody int increaseLike(@PathVariable int feedNo, HttpServletRequest request) {
		System.out.println("좋아요 요청");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		feedService.increaseLike(feedNo, memberId, request.getRequestURI());
		return feedService.feedLikeCount(feedNo); //누른 후 좋아요 갯수
	}
	
	@RequestMapping("/decreaseLike/{feedNo}")
	public @ResponseBody int decreaseLike(@PathVariable int feedNo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		feedService.decreaseLike(feedNo, memberId, request.getRequestURI());
		return feedService.feedLikeCount(feedNo);
	}
	
	//@RequestMapping("/memberlist")
	@RequestMapping(value="memberlist", method=RequestMethod.POST)
	//public String getMemberList(String keyword, Model model ) {
	public String getMemberList(String keyword, HttpSession session, Model model) {
		
		// 지금 DB가 없으니까 일단 임시로 데이터
		List<MemberVo> memberList = feedService.searchListByKeyword(keyword);  
		model.addAttribute("memberList", memberList); 
		  
		model.addAttribute("attribute1", "Hello world");
		
		return "feed/search"; 
	}
	
	@GetMapping("/place/find")
	public @ResponseBody List<FeedVo> placeFileList(@RequestParam String placeDetail){
		List<FeedVo> list = feedService.placeFileList(placeDetail);
		return list;
	}
}