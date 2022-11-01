package com.kosa.instagram.feed.model;

import java.sql.Date;

public class ReplyVo {
	private int replyNo;
	private int feedNo;
	private String memberId;
	private String replyContent;
	private Date replyDate;
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVo [replyNo=" + replyNo + ", feedNo=" + feedNo + ", memberId=" + memberId + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + "]";
	}
}
