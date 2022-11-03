package com.kosa.instagram.feed.service;

public interface IFeedService {
	void writeReply(int feedNo, String memberId, String replyContent);
}
