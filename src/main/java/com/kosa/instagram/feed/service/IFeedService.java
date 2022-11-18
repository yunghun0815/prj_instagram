package com.kosa.instagram.feed.service;

import java.util.List;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.model.HashtagVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;
import com.kosa.instagram.feed.dao.IFeedRepository;

public interface IFeedService {
	
	int countContent(String memberId);
	int countFollowerByUser(String memberId);
	int countFollowByUser(String memberId);
	
	List<Integer> selectContentListByUser(int feedNo);

	void writeReply(int feedNo, String memberId, String replyContent);
	List<MemberVo> searchListByKeyword(String keyword);
//	List<String> searchListByHashtag(String hashtag); 
//	int countHashtag(String hashtag);
	List<HashtagVo> searchListByHashtag(String keyword);
	
	void deleteReply(int replyNo);
	void increaseLike(int feedNo, String memberId, String logURI);
	void decreaseLike(int feedNo, String memberId, String logURI);

	
	void insertFeedContent(FeedVo feed);
	void insertFeedData(FileVo file);
	void insertFeedPlace(FeedVo feed);
	int checkPlace(String placeDetail);
	int selectSeqNum();
	void insertFeedHash(int feedNo, String hashTag);

	FileVo getFile(int fileNo);
	List<FileVo> getFeedFile(String memberId);
	

	JsonVo makeJsonVo(FeedVo feed, String memberId);

	List<FeedVo> getTenFeeds(String memberId, int start, int end);
	List<ReplyVo> getReply(int feedNo);
	int feedLikeCount(int feedNo);
	List<FeedVo> placeFileList(String placeDetail);
	JsonVo getDetailFeed(int feedNo, String memberId);
	
	void updateFeed(FeedVo feed);
	void deleteFeed(FeedVo feed);

	
	List<FileVo> getFileList(String hashtag);

}