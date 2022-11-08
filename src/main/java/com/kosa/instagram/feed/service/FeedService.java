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
import com.kosa.instagram.feed.model.FeedVo;
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
		
		// ���� DB�� �����ϱ� �ϴ� DB�� ��ü�� �� �����
		List<MemberVo> memberList = new ArrayList<MemberVo>(); 
		
		// ������1 ������ ����Ʈ�� ����ֱ�
		MemberVo data1 = new MemberVo();
		data1.setMemberId("jjojjo_0101");
		data1.setNickname("����");
		data1.setName("�ɺ�");
		
		memberList.add(data1);
		

		MemberVo data2 = new MemberVo();
		data2.setMemberId("chocho5");
		data2.setNickname("��������");
		data2.setName("�Ϳ�����");
		
		memberList.add(data2);
				
		
		MemberVo data3 = new MemberVo();
		data3.setMemberId("sns_zzozzo");
		data3.setNickname("������sns");
		data3.setName("zzozzo��");
		data3.setPhoneNumber("010-1111-1111"); 
		
		memberList.add(data3);
		
		
		MemberVo data4 = new MemberVo();
		data4.setMemberId("chocho6");
		data4.setNickname("������");
		data4.setName("������");
		
		memberList.add(data4);		
				
		
		// ���� ��ü ���ؼ�
		List<MemberVo> resultList = new ArrayList<MemberVo>(); // ������ �͵� (��ȸ�ϴ� ����)
		// DB���� ã�� �������� (��ü�˻�)
		for (int i = 0; i < memberList.size(); i++) {
	
			MemberVo tempMember = memberList.get(i);

			String id = tempMember.getMemberId();
			String name = tempMember.getMemberId();
			

			if (id.contains(keyword) || name.contains(keyword)) {
				resultList.add(tempMember);
			}
		}	
	
		return resultList;
		// ���� ����: �ؿ�ó�� �˻�
		// return memberRepository.searchListByKeyword("%"+ keyword+"%");
		
	}
	@Override
	public List<FeedVo> searchListByHashtag(String hashtag) {
		return feedRepository.searchListByHashtag("%"+ hashtag+ "%");
	}
	
	@Override
	public void writeReply(int feedNo, String memberId, String replyContent) {
		MemberVo member = memberRepository.selectMember(memberId);
		ReplyVo reply = new ReplyVo();
		reply.setFeedNo(feedNo);
		reply.setNickname(member.getNickname());
		reply.setReplyContent(replyContent);
	//	reply.setFileData(member.getFileData());
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
	public List<FeedVo> getTenFeeds(String memberId, int start, int end) {
		return feedRepository.getTenFeeds(memberId, start, end);
	}
	
	@Override
	@Transactional
	public JsonVo makeJsonVo(FeedVo feed) {
		JsonVo json = new JsonVo();
		Map<String, FeedVo> feedMap = new HashMap<String, FeedVo>();
		feed.setHashtagList(feedRepository.getHashtagList(feed.getFeedNo()));
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
	public int countContent(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int countFollowerByUser(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int countFollowByUser(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<FeedVo> selectContentListByUser(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberVo> selectFollowerListByUser(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberVo> selectFollowListByUser(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FileVo getFile(int fileNo) {
		return feedRepository.getFile(fileNo);
	}
}
