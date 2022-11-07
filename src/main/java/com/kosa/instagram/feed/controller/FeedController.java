package com.kosa.instagram.feed.controller;

import java.io.UnsupportedEncodingException;

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

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
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
}