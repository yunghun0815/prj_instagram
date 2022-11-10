package com.kosa.instagram.member.service;


import java.util.List;


import com.kosa.instagram.feed.model.FileVo;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberService {
	public void insertMember(MemberVo member);
	

	MemberVo selectFeedMemberInfo(String memberId);
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);
	 

	public MemberVo selectMember(String memberId);
	
	//업데이트
	public void updateMember(MemberVo member, FileVo file);
	
	public void updateMember(MemberVo member);
	
	public Integer selectFileNo(String memberId);
	
	public void deleteMember(MemberVo member);
	
	public String getPassword(String password);
	
	public MemberVo findMmeberId(String email);
	
	public MemberVo findPassword(String memberId, String email);

}
