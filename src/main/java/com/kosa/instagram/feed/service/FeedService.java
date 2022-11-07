package com.kosa.instagram.feed.service;

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
   
   @Override
   @Transactional
   public JsonVo makeJsonVo(FeedVo feed, MemberVo member, List<byte[]> uploadFiles, List<ReplyVo> reply) {
      JsonVo json = new JsonVo();
      Map<String, FeedVo> feedMap = new HashMap<String, FeedVo>();
      feed.setHashtagList(feedRepository.getHashtagList(feed.getFeedNo()));
      feedMap.put("feed", feed);
      json.setFeed(feedMap);
      Map<String, MemberVo> memberMap = new HashMap<String, MemberVo>();
      memberMap.put("member", member);
      json.setMember(memberMap);
      json.setUploadFiles(uploadFiles);
      json.setReply(reply);
      return json;
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
public List<FeedVo> searchListByKeyword(String keyword) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<FeedVo> searchListByHashtag(String hashtag) {
	// TODO Auto-generated method stub
	return null;
}
}