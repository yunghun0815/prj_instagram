package com.kosa.instagram.log.dto;

import java.math.BigDecimal;

public class LogDto {
	private String logDate;
	private BigDecimal likeCount;
	
	
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
	
	
}
