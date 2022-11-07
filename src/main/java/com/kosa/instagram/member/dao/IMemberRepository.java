package com.kosa.instagram.member.dao;

import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {
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
}
