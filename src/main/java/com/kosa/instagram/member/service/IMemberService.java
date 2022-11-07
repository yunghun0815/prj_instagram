package com.kosa.instagram.member.service;

import java.util.List;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberService {
	
	MemberVo selectFeedMemberInfo(String memberId);
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);
	 
}
