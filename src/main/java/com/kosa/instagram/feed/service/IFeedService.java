package com.kosa.instagram.feed.service;

import java.util.List;

import com.kosa.instagram.feed.dao.IFeedRepository;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.member.model.MemberVo;


public interface IFeedService {
	
	int countContent(String memberId);
	int countFollowerByUser(String memberId);
	int countFollowByUser(String memberId);
	
	List<FeedVo> selectContentListByUser(String memberId);
	List<MemberVo> selectFollowerListByUser(String memberId);
	List<MemberVo> selectFollowListByUser(String memberId);

}
