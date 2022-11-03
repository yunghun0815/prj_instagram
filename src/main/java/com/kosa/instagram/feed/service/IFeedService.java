package com.kosa.instagram.feed.service;

import java.util.List;

import com.kosa.instagram.feed.model.FeedVo;

public interface IFeedService {

	void writeReply(int feedNo, String memberId, String replyContent);
	List<FeedVo> searchListByKeyword(String keyword);
	List<FeedVo> searchListByHashtag(String hashtag); 
	
}
