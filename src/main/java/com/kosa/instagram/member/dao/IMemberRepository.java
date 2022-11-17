package com.kosa.instagram.member.dao;


import java.util.List;


import com.kosa.instagram.feed.model.FileVo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.feed.model.FeedVo;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {


	MemberVo selectFeedMemberInfo(String memberId);
	List<MemberVo> selectFollowerByUser(String memberId);
	List<MemberVo> selectFollowByUser(String memberId);

	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	
	public void insertFile(FileVo file);

	public void updateFile(FileVo file);
	
	public Integer selectFileNo(String memberId);

	public void updateMember(MemberVo member);
	
	public void deleteMember(MemberVo member);
	
	public String getPassword(String password);
	

	List<MemberVo> searchListByKeyword(@Param("keyword") String keyword);


	//이메일을 이용해서 아이디 찾기
	public String findMemberId(String email);

	//멤버아이디랑 패스워드 보여줘야 하고 아이디와 이메일 이용
	public String findPassword(@Param("memberId") String memberId, @Param("email")String email);


	//아이디 중복체크
	public String checkId(String memberId);
	public String checkNickname(String nickname);
	public String checkEmail(String email);
	
	void followMember(@Param("fromId")String fromId, @Param("toId")String toId);
	void unfollowMember(@Param("fromId")String fromId, @Param("toId")String toId);

}
