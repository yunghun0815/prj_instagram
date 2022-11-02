package com.kosa.instagram.feed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.LogVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IFeedRepository {
	void writeReply(ReplyVo reply);
	void deleteReply(int replyNo);
	void increaseLike(@Param("feedNo")int feedNo, @Param("memberId")String memberId);
	void decreaseLike(int feedNo);
	void makeLog(LogVo log);
	
	FeedVo getFeed(String feedNo); //fileNo, likeCount, hashtagList, file¾øÀ½
	MemberVo getMember(String memberId);
	List<byte[]> getUploadFiles(int feedNo);
	List<ReplyVo> getReply(int feedNo);
}
