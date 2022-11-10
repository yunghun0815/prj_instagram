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
	      
	      // 지금 DB가 없으니까 일단 DB를 대체할 거 만들기
	      List<MemberVo> memberList = new ArrayList<MemberVo>(); 
	      
	      // 데이터1 생성후 리스트에 집어넣기
	      MemberVo data1 = new MemberVo();
	      data1.setMemberId("jjojjo_0101");
	      data1.setNickname("쪼쪼");
	      data1.setName("쪼블리");
	      
	      memberList.add(data1);
	      

	      MemberVo data2 = new MemberVo();
	      data2.setMemberId("chocho5");
	      data2.setNickname("강아지님");
	      data2.setName("귀여운쪼");
	      
	      memberList.add(data2);
	            
	      
	      MemberVo data3 = new MemberVo();
	      data3.setMemberId("sns_zzozzo");
	      data3.setNickname("쪼쪼의sns");
	      data3.setName("zzozzo쪼");
	      data3.setPhoneNumber("010-1111-1111"); 
	      
	      memberList.add(data3);
	      
	      
	      MemberVo data4 = new MemberVo();
	      data4.setMemberId("chocho6");
	      data4.setNickname("강아지");
	      data4.setName("오쪼쪼");
	      
	      memberList.add(data4);      
	            
	      
	      // 쿼리 대체 위해서
	      List<MemberVo> resultList = new ArrayList<MemberVo>(); // 리턴할 것들 (조회하는 개념)
	      // DB에서 찾는 느낌으로 (전체검색)
	      for (int i = 0; i < memberList.size(); i++) {
	   
	         MemberVo tempMember = memberList.get(i);


	         String id = tempMember.getMemberId();
	         String name = tempMember.getMemberId();
	         


	         if (id.contains(keyword) || name.contains(keyword)) {
	            resultList.add(tempMember);
	         }
	      }   
	   
	      return resultList;
	      // 원래 내용: 밑에처럼 검색
	      // return memberRepository.searchListByKeyword("%"+ keyword+"%");
	      
	   }

	@Override
	public List<String> searchListByHashtag(String hashtag) {
		return feedRepository.searchListByHashtag("%"+ hashtag+ "%");
	}
	
	@Override
	public void writeReply(int feedNo, String memberId, String replyContent) {
		MemberVo member = memberRepository.selectMember(memberId);
		ReplyVo reply = new ReplyVo();
		reply.setFeedNo(feedNo);
		reply.setNickname(member.getNickname());
		reply.setReplyContent(replyContent);
		reply.setFileNo(member.getFileNo());
//		System.out.println(reply.toString());
	//	reply.setFileData(member.getFileData());
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
//		LogVo log = new LogVo();
//		log.setLogURI(logURI);
//		log.setMemberId(memberId);
//		log.setFeedNo(feedNo);
//		log.setLogLikeCheck(1);
//		feedRepository.makeLog(log);
	}
	
	@Override
	public void decreaseLike(int feedNo, String memberId, String logURI) {
		feedRepository.decreaseLike(feedNo, memberId);
//		LogVo log = new LogVo();
//		log.setLogURI(logURI);
//		log.setMemberId(memberId);
//		log.setFeedNo(feedNo);
//		log.setLogLikeCheck(0);
//		feedRepository.makeLog(log);
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
}