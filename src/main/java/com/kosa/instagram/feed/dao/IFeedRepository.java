package com.kosa.instagram.feed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.LogVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
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


<<<<<<< HEAD

	List<FeedVo> searchListByHashtag(@Param("hashtaglist") String hashtagist);
	int countContent(String memberId);
	int countFollower(String memberId);
	int countFollow(String memberId);
	int selectSeqNum();
=======
	List<MemberVo> searchListByKeyword(@Param("keyword") String keyword);
	List<String> searchListByHashtag(@Param("hashtag") String hashtag);
	void countContent(String memberId);
	void countFollower(String memberId);
	void countFollow(String memberId);
>>>>>>> branch 'master' of https://github.com/yunghun0815/prj_instagram.git

	List<FileVo> selectContentListByUser(String memberId);
	void insertFeedContent(FeedVo feed);
	void insertFeedData(FileVo file);
	void insertFeedPlace(FeedVo feed);
	int checkPlace(String placeDetail);
	
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);
	FileVo getFile(int fileNo);
	int likeCheck(@Param("memberId") String memberId, @Param("feedNo") int feedNo);
	
	void insertFeedHash(@Param("feedNo")int feedNo,@Param("hashTag") String hashTag);


	
	

	
}