package com.kosa.instagram.feed.dao;

public interface IFeedRepository {
	void writeReply(int feedNo, String replyContent);
	void deleteReply(int replyNo);
	void likeFeed(int feedNo);
	void cancelLike(int feedNo, String memberId);
}
