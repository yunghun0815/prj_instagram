package com.kosa.instagram.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.instagram.LogVo;
import com.kosa.instagram.feed.dao.IFeedRepository;
import com.kosa.instagram.feed.model.ReplyVo;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.member.dao.IMemberRepository;
import com.kosa.instagram.member.model.MemberVo;

@Service
public class FeedService implements IFeedService {
	@Autowired
	IFeedRepository feedRepository;
	
	@Override  
	public List<FeedVo> searchListByKeyword(String keyword) {
		return feedRepository.searchListByKeyword("%"+ keyword+"%");
		
	}
	@Override
	public List<FeedVo> searchListByHashtag(String hashtag) {
		return feedRepository.searchListByHashtag("%"+ hashtag+ "%");
	}
	@Autowired
	IMemberRepository memberRepository;
	
	@Override
	public void writeReply(int feedNo, String memberId, String replyContent) {
		MemberVo member = memberRepository.selectMember(memberId);
		ReplyVo reply = new ReplyVo();
		reply.setFeedNo(feedNo);
		reply.setNickname(member.getNickname());
		reply.setReplyContent(replyContent);
		reply.setFileData(member.getFileData());
		feedRepository.writeReply(reply);
	}
	
	@Override
	public void deleteReply(int replyNo) {
		feedRepository.deleteReply(replyNo);
	}

	@Override
	@Transactional
	public void increaseLike(int feedNo, String memberId, String logURI) {
		feedRepository.increaseLike(feedNo, memberId);
		LogVo log = new LogVo();
		log.setLogURI(logURI);
		log.setMemberId(memberId);
		log.setFeedNo(feedNo);
		log.setLogLikeCheck(1);
		feedRepository.makeLog(log);
	}
	
	@Override
	@Transactional
	public void decreaseLike(int feedNo, String memberId, String logURI) {
		feedRepository.decreaseLike(feedNo, memberId);
		LogVo log = new LogVo();
		log.setLogURI(logURI);
		log.setMemberId(memberId);
		log.setFeedNo(feedNo);
		log.setLogLikeCheck(0);
		feedRepository.makeLog(log);
	}
}
