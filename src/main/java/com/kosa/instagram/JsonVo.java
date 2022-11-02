package com.kosa.instagram;

import java.util.List;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.model.MemberVo;

public class JsonVo {
	private FeedVo feed;
	private MemberVo member;
	private List<byte[]> uploadFiles;
	private List<ReplyVo> reply;
	
	public FeedVo getFeed() {
		return feed;
	}
	public void setFeed(FeedVo feed) {
		this.feed = feed;
	}
	public MemberVo getMember() {
		return member;
	}
	public void setMember(MemberVo member) {
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
