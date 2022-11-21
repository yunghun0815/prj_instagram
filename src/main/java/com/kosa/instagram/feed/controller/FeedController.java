package com.kosa.instagram.feed.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.bind.annotation.RequestParam;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.model.HashtagVo;
import com.kosa.instagram.feed.model.ReplyVo;

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
//      MemberVo member=memberService.selectFeedMemberInfo(memberId);
      MemberVo member = memberService.selectMember(memberId);
      model.addAttribute("nickname",member.getNickname());
      model.addAttribute("name",member.getName());
      model.addAttribute("memberProfileFileId", member.getFileNo());
      


		
		List<FileVo> getFeedFile =feedService.getFeedFile(memberId);
		model.addAttribute("contentList",getFeedFile);
		
		
		
		
		
		List<MemberVo> followerList=memberService.selectFollowerByUser(memberId);
		model.addAttribute("followerList", followerList);
		
		
		
		List<MemberVo> followList=memberService.selectFollowByUser(memberId);
		model.addAttribute("followList",followList);
		
		return "feed/userfeed";
	
	}
	



	@RequestMapping(value="/writefeed/{memberId}",method=RequestMethod.GET)
	public String insertFeed(FileVo file,@PathVariable String memberId,Model model ) {
		model.addAttribute("memberId",memberId);
		MemberVo member = memberService.selectMember(memberId);
		model.addAttribute("memberProfileFileId", member.getFileNo());
		return "feed/writefeed";
	}
	
	@RequestMapping(value="/writefeed",method=RequestMethod.POST)
	public String writefeed(List<MultipartFile> fileList, String[] hashtag, HttpServletRequest req,FileVo file) {




		FeedVo feed=new FeedVo();
		String feedContent=req.getParameter("feedContent");
		String placeTitle=req.getParameter("placeTitle");
		String placeDetail=req.getParameter("placeDetail");
		
		String memberId=req.getParameter("memberId");
		feed.setFeedContent(feedContent);
		feed.setPlaceTitle(placeTitle);
		feed.setPlaceDetail(placeDetail);
		feed.setMemberId(memberId);
		
		
		
		
	
		if(placeTitle!=null && !placeTitle.equals("")) {
			if(placeDetail == null || placeDetail.equals("")) {
				placeDetail = placeTitle+"KOSA";
				feed.setPlaceDetail(placeDetail);
			}
		int check=feedService.checkPlace(placeDetail); //등록된 장소가 있는지 없는지
		
		System.out.println(check);
		if(check==0) { //등록장소가 없으면
			feedService.insertFeedPlace(feed); //장소등록
		}
		}
		feedService.insertFeedContent(feed); //피드 등록
		
		int seqnum=(feedService.selectSeqNum())-1;
		System.out.println(hashtag);
		if(hashtag!=null) {
			for(String hash: hashtag) {
				feedService.insertFeedHash(seqnum, hash);
				System.out.println(hash);
			}			
		}
		
		try {
		for(MultipartFile mf: fileList) {
			
			
			
			
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

   @RequestMapping(value="/writereply/{feedNo}", method=RequestMethod.POST)
   public @ResponseBody List<ReplyVo> writeReply(@PathVariable int feedNo, @RequestParam String replyInput, HttpServletRequest request) {
      HttpSession session = request.getSession();
      String memberId = (String)session.getAttribute("memberId");
      feedService.writeReply(feedNo, memberId, replyInput);
      return feedService.getReply(feedNo);
   }
   
   @RequestMapping("/deletereply/{feedNo}/{replyNo}")
   public @ResponseBody List<ReplyVo> deleteReply(@PathVariable int feedNo, @PathVariable int replyNo) {
      feedService.deleteReply(replyNo);
      return feedService.getReply(feedNo);
   }
   
   @RequestMapping("/increaselike/{feedNo}")
   public @ResponseBody int increaseLike(@PathVariable int feedNo, HttpServletRequest request) {
      System.out.println("좋아요 요청");
      HttpSession session = request.getSession();
      String memberId = (String)session.getAttribute("memberId");
      feedService.increaseLike(feedNo, memberId, request.getRequestURI());
      return feedService.feedLikeCount(feedNo); //누른 후 좋아요 갯수
   }
   
   @RequestMapping("/decreaselike/{feedNo}")
   public @ResponseBody int decreaseLike(@PathVariable int feedNo, HttpServletRequest request) {
      HttpSession session = request.getSession();
      String memberId = (String)session.getAttribute("memberId");
      feedService.decreaseLike(feedNo, memberId, request.getRequestURI());
      return feedService.feedLikeCount(feedNo);
   }
  
  
  
 
   
  
	@RequestMapping("/getmemberlist")
	public String getMemberList(@RequestParam String keyword, HttpSession session, Model model) {
		
		// 1. 계정 리스트를 키워드로 검색
		List<MemberVo> memberList = feedService.searchListByKeyword(keyword);
		model.addAttribute("memberList", memberList);
	
		// 2. 해시태그 리스트를 키워드로 검색
		List<HashtagVo> hashtagList = feedService.searchListByHashtag(keyword);
		model.addAttribute("hashtagList", hashtagList);
				
		return "feed/search"; 
	}
	
	
	
	@RequestMapping("/filelist/{hashtag}")
	public  String getFileList(@PathVariable String hashtag, Model model ) {
		
		// 파일 리스트 조회 : 파라메터=해시태그
		List<FileVo> fileList = feedService.getFileList(hashtag);
		
		// 조회결과를 모델에 세팅
		model.addAttribute("fileList", fileList);
		model.addAttribute("hashcount", fileList.size());
		
		// 리턴
		return "/feed/filelist";
	}
	

	
	
	@GetMapping("/place/find")
	public @ResponseBody List<FeedVo> placeFileList(@RequestParam String placeDetail){
		List<FeedVo> list = feedService.placeFileList(placeDetail);
		return list;
	}
	@GetMapping("/feed/detail/{feedNo}")
	public String detailPage(@PathVariable int feedNo, Model model) {
		model.addAttribute("feedNo", feedNo);
		return "feed/detail";
	}
	
	@GetMapping("/feed/detail")
	public @ResponseBody JsonVo feedDetail(@RequestParam int feedNo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		return  feedService.getDetailFeed(feedNo, memberId);
	}
	
	@RequestMapping(value="/feed/update", method=RequestMethod.GET)
	public String updateFeed(@RequestParam int feedNo, HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		FeedVo feed = feedService.getDetailFeed(feedNo, memberId).getFeed().get("feed");
		model.addAttribute("feed", feed);
		model.addAttribute("feedNo", feedNo);
		List<Integer> selectContentbyUser =feedService.selectContentListByUser(feedNo);
		model.addAttribute("contentList",selectContentbyUser);
		
		
		
		return "feed/updatefeed";
	}
	

	@RequestMapping(value="/feed/update/{feedNo}", method=RequestMethod.POST)
	public String updateFeed(@PathVariable int feedNo, String[] hashtag, HttpServletRequest req) {
		FeedVo feed=new FeedVo();
		
		String feedContent=req.getParameter("feedContent");
		String placeTitle=req.getParameter("placeTitle");
		String placeDetail=req.getParameter("placeDetail");
		String memberId=req.getParameter("memberId");


		feed.setFeedNo(feedNo);
		feed.setFeedContent(feedContent);
		feed.setPlaceTitle(placeTitle);
		feed.setPlaceDetail(placeDetail);
		feed.setMemberId(memberId);
		
		if(placeTitle==null || placeTitle.equals("")) {
			feed.setPlaceDetail(null);
			feed.setPlaceTitle(null);
		}
		
		feedService.updateFeed(feed);
		if(hashtag!=null) {
		for(String hash: hashtag) {
			feedService.insertFeedHash(feedNo, hash);
		}
		}
		
		return "redirect:/feed/detail/"+feedNo;
	}
	
	@RequestMapping("/feed/delete")
	public String deleteFeed(@RequestParam int feedNo, HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		FeedVo feed = feedService.getDetailFeed(feedNo, memberId).getFeed().get("feed");
		feedService.deleteFeed(feed);
		return "redirect:/userfeed/"+memberId;
	}
	


   
  
}