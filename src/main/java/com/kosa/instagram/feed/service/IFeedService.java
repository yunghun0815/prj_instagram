package com.kosa.instagram.feed.service;

import java.util.List;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IFeedService {
	void writeReply(int feedNo, String memberId, String replyContent);
	void deleteReply(int replyNo);
	void increaseLike(int feedNo, String memberId, String logURI);
	void decreaseLike(int feedNo, String memberId, String logURI);
	JsonVo makeJsonVo(FeedVo feed, MemberVo member, List<byte[]> uploadFiles, List<ReplyVo> reply);
}
