package com.kosa.instagram.feed.model;

import java.sql.Date;
import java.util.Arrays;

public class ReplyVo {
	private int replyNo;
	private int feedNo;
	private String nickname;
	private String replyContent;
	private Date replyDate;
	private byte[] fileData;
	
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
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
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
				+ replyContent + ", replyDate=" + replyDate + ", fileData=" + Arrays.toString(fileData) + "]";
	}
}
