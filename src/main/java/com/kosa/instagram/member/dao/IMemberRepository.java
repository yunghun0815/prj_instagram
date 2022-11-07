package com.kosa.instagram.member.dao;

import java.util.List;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {
	MemberVo selectMember(String memberId);
	MemberVo selectFeedMemberInfo(String memberId);
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);
}
