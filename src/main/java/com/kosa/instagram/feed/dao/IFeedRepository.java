package com.kosa.instagram.feed.dao;

import java.util.List;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IFeedRepository {

	void countContent(String memberId);
	void countFollower(String memberId);
	void countFollow(String memberId);
	List<FeedVo> selectContentListByUser(String memberId);
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);
	
	
}
