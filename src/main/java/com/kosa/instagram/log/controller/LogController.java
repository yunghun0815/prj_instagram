package com.kosa.instagram.log.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.instagram.log.dto.LogDto;
import com.kosa.instagram.log.service.LogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LogController {
	
	@Autowired
	LogService logServiceImpl;
	
	@ResponseBody
	@GetMapping("/log/likeCount/gender")
	public Map<String,BigDecimal> likeCount(HttpSession session) {
		
		return logServiceImpl.likeCount(session.getAttribute("memberId").toString());
	}
	
	@ResponseBody
	@GetMapping("/log/likeCount/date")
	public List<LogDto> likeCountDate(HttpSession session){
		return logServiceImpl.likeCountDate(session.getAttribute("memberId").toString());
	}
	
	@ResponseBody
	@GetMapping("/log/search/keyword")
	public List<LogDto> searchKeyword(){
		return logServiceImpl.searchKeyword();
	}
}
