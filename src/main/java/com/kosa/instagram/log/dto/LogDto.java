package com.kosa.instagram.log.dto;

import java.math.BigDecimal;

public class LogDto {
	private String logDate;
	private BigDecimal likeCount;
	
	private String keyword;
	private String age;
	private BigDecimal cnt;
	
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public BigDecimal getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(BigDecimal likeCount) {
		this.likeCount = likeCount;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public BigDecimal getCnt() {
		return cnt;
	}
	public void setCnt(BigDecimal cnt) {
		this.cnt = cnt;
	}
	
	
}
