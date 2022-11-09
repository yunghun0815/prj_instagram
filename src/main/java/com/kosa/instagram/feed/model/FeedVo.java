
package com.kosa.instagram.feed.model;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class FeedVo {
	private int feedNo;
	private String memberId;
	private int fileNo;
	private String feedContent;
	private Date uploadDate;
	private String placeDetail;
	private String placeTitle;
	private int likeCount;
	private List<String> hashtagList;
	private List<MultipartFile> file;
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public String getPlaceTitle() {
		return placeTitle;
	}
	public void setPlaceTitle(String placeTitle) {
		this.placeTitle = placeTitle;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFeedContent() {
		return feedContent;
	}
	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getPlaceDetail() {
		return placeDetail;
	}
	public void setPlaceDetail(String placeDetail) {
		this.placeDetail = placeDetail;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public List<String> getHashtagList() {
		return hashtagList;
	}
	public void setHashtagList(List<String> hashtagList) {
		this.hashtagList = hashtagList;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "FeedVo [feedNo=" + feedNo + ", memberId=" + memberId + ", fileNo=" + fileNo + ", feedContent="
				+ feedContent + ", uploadDate=" + uploadDate + ", placeDetail=" + placeDetail + ", likeCount="
				+ likeCount + ", hashtagList=" + hashtagList + ", file=" + file + "]";
	}
	
	
}
