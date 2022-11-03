package com.kosa.instagram.feed.service;

import java.util.List;

import com.kosa.instagram.feed.model.FeedVo;

public interface IFeedService {

	List<FeedVo> searchListByKeyword(String keyword);
	List<FeedVo> searchListByHashtag(String hashtag); 
	
}