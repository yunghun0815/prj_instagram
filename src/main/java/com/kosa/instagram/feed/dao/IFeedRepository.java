package com.kosa.instagram.feed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.LogVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.model.HashtagVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;


public interface IFeedRepository {

	void writeReply(ReplyVo reply);
	void deleteReply(int replyNo);
	void increaseLike(@Param("feedNo")int feedNo, @Param("memberId")String memberId);
	void decreaseLike(@Param("feedNo")int feedNo, @Param("memberId")String memberId);
	void makeLog(LogVo log);
	List<FeedVo> getTenFeeds(@Param("memberId")String memberId, @Param("start")int start, @Param("end")int end); //fileNo, hashtagList, file����
	List<String> getHashtagList(int feedNo);
	MemberVo getWriter(int feedNo);

	List<Integer> getUploadFiles(int feedNo);
	List<ReplyVo> getReply(int feedNo);
	int feedLikeCount(int feedNo);


	int countContent(String memberId);
	int countFollower(String memberId);
	int countFollow(String memberId);
	int selectSeqNum();

	List<MemberVo> searchListByKeyword(@Param("keyword") String keyword);
//	List<String> searchListByHashtag(@Param("hashtag") String hashtag);
//	int countHashtag(String hashtag);

	List<HashtagVo> searchListByHashtag(@Param("keyword") String keyword);

	List<FileVo> selectContentListByUser(String memberId);
	void insertFeedContent(FeedVo feed);
	void insertFeedData(FileVo file);
	void insertFeedPlace(FeedVo feed);
	int checkPlace(String placeDetail);
	
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);
	FileVo getFile(int fileNo);
	int likeCheck(@Param("memberId") String memberId, @Param("feedNo") int feedNo);
	List<FeedVo> placeFileList(String placeDetail);
	
	void insertFeedHash(@Param("feedNo")int feedNo,@Param("hashTag") String hashTag);
	int getLikeCount(int feedNo);
	FeedVo getDetailFeed(int feedNo);
	
	

	
}