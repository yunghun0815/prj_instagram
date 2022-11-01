package com.kosa.instagram.feed.model;

import java.util.Arrays;

public class FileVo {
	private int fileNo;
	private int feedNo;
	private byte[] fileData;
	private String fileName;
	private int fileSize;
	private String fileType;
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "FileVo [fileNo=" + fileNo + ", feedNo=" + feedNo +  ", fileName=" + fileName + ", fileSize=" + fileSize + ", fileType=" + fileType + "]";
	}
}
