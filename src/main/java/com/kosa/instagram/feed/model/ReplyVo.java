package com.kosa.instagram.feed.model;

import java.sql.Date;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReplyVo {
	private int replyNo;
	private int feedNo;
	private String nickname;
	private String memberId;
	private String replyContent;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date replyDate;
	private int fileNo;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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
		return "ReplyVo [replyNo=" + replyNo + ", feedNo=" + feedNo + ", nickname=" + nickname + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + ", fileNo=" + fileNo + "]";
	}
}