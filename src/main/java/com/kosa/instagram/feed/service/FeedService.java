package com.kosa.instagram.feed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.feed.dao.IFeedRepository;
import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.member.model.MemberVo;

@Service
public class FeedService implements IFeedService {

	@Autowired
	IFeedRepository feedRepository;
	
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
	public List<FeedVo> selectContentListByUser(String memberId) {
		
		return null;
	}

	@Override
	public List<MemberVo> selectFollowerListByUser(String memberId) {
		
		return null;
	}

	@Override
	public List<MemberVo> selectFollowListByUser(String memberId) {
		
		return null;
	}

}
