package com.kosa.instagram.feed.service;

public interface IFeedService {
	void writeReply(int feedNo, String memberId, String replyContent);
	void deleteReply(int replyNo);
	void increaseLike(int feedNo, String memberId, String logURI);
	void decreaseLike(int feedNo, String memberId, String logURI);
}
