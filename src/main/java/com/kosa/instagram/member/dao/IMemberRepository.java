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

	//회원가입(사진 x)
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	//프로필사진 등록
	public void insertFile(FileVo file);
	//프로필사진 수정
	public void updateFile(FileVo file);
	
	public Integer selectFileNo(String memberId);
	//비밀번호,닉네임, 핸드폰 번호 수정
	public void updateMember(MemberVo member);
	
	//회원정보 삭제
	public void deleteMember(MemberVo member);
	
	public String getPassword(String password);
	

	//이메일을 이용해서 아이디 찾기
	public MemberVo findMemberId(String email);
	
	//멤버아이디랑 패스워드 보여줘야 하고 아이디와 이메일 이용
	public MemberVo findPassword(@Param("memberId") String memberId, @Param("email")String email);

}
