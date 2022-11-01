package com.kosa.instagram;

import java.sql.Date;

public class LogVo {
	private int logNo;
	private Date logTime;
	private String logURI;
	private String memberId;
	private String logKeyword;
	private int feedNo;
	private int logLikeCheck;
	
	public int getLogNo() {
		return logNo;
	}
	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public String getLogURI() {
		return logURI;
	}
	public void setLogURI(String logURI) {
		this.logURI = logURI;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLogKeyword() {
		return logKeyword;
	}
	public void setLogKeyword(String logKeyword) {
		this.logKeyword = logKeyword;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public int getLogLikeCheck() {
		return logLikeCheck;
	}
	public void setLogLikeCheck(int logLikeCheck) {
		this.logLikeCheck = logLikeCheck;
	}
	
	@Override
	public String toString() {
		return "LogVo [logNo=" + logNo + ", logTime=" + logTime + ", logURI=" + logURI + ", memberId=" + memberId
				+ ", logKeyword=" + logKeyword + ", feedNo=" + feedNo + ", logLikeCheck=" + logLikeCheck + "]";
	}
}
