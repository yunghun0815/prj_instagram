package com.kosa.instagram.feed.service;

import java.util.List;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;
import com.kosa.instagram.feed.dao.IFeedRepository;

public interface IFeedService {
	
	int countContent(String memberId);
	int countFollowerByUser(String memberId);
	int countFollowByUser(String memberId);
	
	List<FeedVo> selectContentListByUser(String memberId);
	List<MemberVo> selectFollowerListByUser(String memberId);
	List<MemberVo> selectFollowListByUser(String memberId);

	void writeReply(int feedNo, String memberId, String replyContent);
	List<MemberVo> searchListByKeyword(String keyword);
	List<FeedVo> searchListByHashtag(String hashtag); 
	void deleteReply(int replyNo);
	void increaseLike(int feedNo, String memberId, String logURI);
	void decreaseLike(int feedNo, String memberId, String logURI);
	JsonVo makeJsonVo(FeedVo feed);
	List<FeedVo> getTenFeeds(String memberId, int start, int end);
}
