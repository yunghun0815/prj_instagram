package com.kosa.instagram.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.member.dao.IMemberRepository;
import com.kosa.instagram.member.model.MemberVo;
import com.kosa.instagram.member.service.IMemberService;

@Service
public class MemberService implements IMemberService{
	
	@Autowired
	IMemberRepository memberRepository;

	@Override
	public MemberVo selectFeedMemberInfo(String memberId) {
		
		return memberRepository.selectFeedMemberInfo(memberId);
	}

	@Override
	public List<MemberVo> selectFollowerByUser(String memberId) {
		return memberRepository.selectFollowerByUser(memberId);
	}

	@Override
	public List<MemberVo> selectFollowByUser(String memberId) {
		return memberRepository.selectFollowByUser(memberId);
	}
	
	
}
