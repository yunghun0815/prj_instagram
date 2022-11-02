package com.kosa.instagram;

import java.util.List;
import java.util.Map;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;

public class JsonVo {
	private Map<String,FeedVo> feed;
	private Map<String,MemberVo> member;
	private List<byte[]> uploadFiles;
	private List<ReplyVo> reply;
	
	public Map<String, FeedVo> getFeed() {
		return feed;
	}
	public void setFeed(Map<String, FeedVo> feed) {
		this.feed = feed;
	}
	public Map<String, MemberVo> getMember() {
		return member;
	}
	public void setMember(Map<String, MemberVo> member) {
		this.member = member;
	}
	public List<byte[]> getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(List<byte[]> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public List<ReplyVo> getReply() {
		return reply;
	}
	public void setReply(List<ReplyVo> reply) {
		this.reply = reply;
	}
	
	@Override
	public String toString() {
		return "JsonVo [feed=" + feed + ", member=" + member + ", uploadFiles=" + uploadFiles + ", reply=" + reply
				+ "]";
	}
}
