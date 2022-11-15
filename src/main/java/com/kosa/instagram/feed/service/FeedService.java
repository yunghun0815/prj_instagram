package com.kosa.instagram.feed.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.instagram.JsonVo;
import com.kosa.instagram.LogVo;
import com.kosa.instagram.feed.dao.IFeedRepository;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.feed.model.HashtagVo;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.member.dao.IMemberRepository;
import com.kosa.instagram.member.model.MemberVo;

@Service
public class FeedService implements IFeedService {

	@Autowired
	IFeedRepository feedRepository;

	@Autowired
	IMemberRepository memberRepository;

	@Override
	public List<MemberVo> searchListByKeyword(String keyword) {
		return feedRepository.searchListByKeyword("%" + keyword + "%");
	}

	@Override
	public List<HashtagVo> searchListByHashtag(String keyword) {
		return feedRepository.searchListByHashtag("%" + keyword + "%");
	}

	@Override
	public void writeReply(int feedNo, String memberId, String replyContent) {
		MemberVo member = memberRepository.selectMember(memberId);
		ReplyVo reply = new ReplyVo();
		reply.setFeedNo(feedNo);
		reply.setNickname(member.getNickname());
		reply.setReplyContent(replyContent);
		reply.setFileNo(member.getFileNo());
		feedRepository.writeReply(reply);
	}

	@Override
	public void deleteReply(int replyNo) {
		feedRepository.deleteReply(replyNo);
	}

	@Override
	public int countContent(String memberId) {
		return feedRepository.countContent(memberId);
	}

	@Override
	public int countFollowerByUser(String memberId) {
		return feedRepository.countFollower(memberId);
	}

	@Override
	public int countFollowByUser(String memberId) {
		return feedRepository.countFollow(memberId);
	}

	@Override
	public List<FileVo> selectContentListByUser(String memberId) {
		return feedRepository.selectContentListByUser(memberId);
	}

	@Override
	public void increaseLike(int feedNo, String memberId, String logURI) {
		feedRepository.increaseLike(feedNo, memberId);
	}

	@Override
	public void decreaseLike(int feedNo, String memberId, String logURI) {
		feedRepository.decreaseLike(feedNo, memberId);
	}

	@Override
	public List<FeedVo> getTenFeeds(String memberId, int start, int end) {
		return feedRepository.getTenFeeds(memberId, start, end);
	}

	@Override
	@Transactional
	public JsonVo makeJsonVo(FeedVo feed, String memberId) {
		JsonVo json = new JsonVo();
		Map<String, FeedVo> feedMap = new HashMap<String, FeedVo>();
		feed.setHashtagList(feedRepository.getHashtagList(feed.getFeedNo()));
		feed.setLikeCheck(feedRepository.likeCheck(memberId, feed.getFeedNo()));
		feedMap.put("feed", feed);
		json.setFeed(feedMap);
		MemberVo member = memberRepository.selectMember(feed.getMemberId());
		Map<String, MemberVo> memberMap = new HashMap<String, MemberVo>();
		memberMap.put("member", member);
		json.setMember(memberMap);
		List<Integer> fileNoList = feedRepository.getUploadFiles(feed.getFeedNo());
		json.setUploadFiles(fileNoList);
		List<ReplyVo> replyList = feedRepository.getReply(feed.getFeedNo());
		json.setReply(replyList);
		return json;
	}

	@Override
	public List<ReplyVo> getReply(int feedNo) {
		return feedRepository.getReply(feedNo);
	}

	@Override
	public int feedLikeCount(int feedNo) {
		return feedRepository.feedLikeCount(feedNo);
	}

	@Override
	public FileVo getFile(int fileNo) {
		return feedRepository.getFile(fileNo);
	}

	@Transactional
	public void insertFeedContent(FeedVo feed) {
		feedRepository.insertFeedContent(feed);
	}

	@Transactional
	public void insertFeedData(FileVo file) {
		feedRepository.insertFeedData(file);
	}

	@Override
	public int selectSeqNum() {

		return feedRepository.selectSeqNum();
	}

	@Transactional
	public void insertFeedPlace(FeedVo feed) {
		feedRepository.insertFeedPlace(feed);

	}

	@Override
	public int checkPlace(String placeDetail) {
		return feedRepository.checkPlace(placeDetail);
	}

	@Override
	public void insertFeedHash(int feedNo, String hashTag) {
		feedRepository.insertFeedHash(feedNo, hashTag);

	}

	@Override
	public List<FeedVo> placeFileList(String placeDetail) {
		return feedRepository.placeFileList(placeDetail);
	}

	@Override
	public JsonVo getDetailFeed(int feedNo, String memberId) {
		JsonVo json = new JsonVo();

		Map<String, FeedVo> feedMap = new HashMap<String, FeedVo>();
		FeedVo feed = feedRepository.getDetailFeed(feedNo);
		feed.setHashtagList(feedRepository.getHashtagList(feedNo));
		feed.setLikeCheck(feedRepository.likeCheck(memberId, feedNo));
		feed.setLikeCount(feedRepository.getLikeCount(feedNo));
		feedMap.put("feed", feed);
		json.setFeed(feedMap);
		MemberVo member = memberRepository.selectMember(feed.getMemberId());
		Map<String, MemberVo> memberMap = new HashMap<String, MemberVo>();
		memberMap.put("member", member);
		json.setMember(memberMap);
		List<Integer> fileNoList = feedRepository.getUploadFiles(feedNo);
		json.setUploadFiles(fileNoList);
		List<ReplyVo> replyList = feedRepository.getReply(feedNo);
		json.setReply(replyList);
		return json;
	}

	@Override
	public List<FileVo> getFeedFile(String memberId) {
		return feedRepository.getFeedFile(memberId);
	}

	@Override
	public void updateFeed(FeedVo feed) {
		if (feedRepository.checkPlace(feed.getPlaceDetail()) == 0) {
			feedRepository.insertFeedPlace(feed);
		}
		feedRepository.deleteHashtag(feed.getFeedNo());
		feedRepository.updateFeedContent(feed);
	}

	@Override
	public void deleteFeed(FeedVo feed) {
		String placeDetail = feed.getPlaceDetail();
		int feedNo = feed.getFeedNo();
		
		feedRepository.deleteHashtag(feedNo);
		feedRepository.deleteLog(feedNo);
		feedRepository.deleteFeedReply(feedNo);
		feedRepository.deleteFeed(feedNo);
		if(placeDetail!=null && !placeDetail.equals("")) {
			feedRepository.deletePlace(placeDetail);
			System.out.println(placeDetail);}
		}

	@Override
	public List<FileVo> getFileList(String hashtag) {

		return feedRepository.getFileList(hashtag);
	}

}