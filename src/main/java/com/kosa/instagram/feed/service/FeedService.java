package com.kosa.instagram.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.feed.dao.IFeedRepository;
import com.kosa.instagram.feed.model.ReplyVo;

@Service
public class FeedService implements IFeedService {

	@Autowired
	IFeedRepository feedRepository;
	
	@Override
	public void writeReply(int feedNo, String memberId, String replyContent) {
		ReplyVo reply = new ReplyVo();
		
	}
}
