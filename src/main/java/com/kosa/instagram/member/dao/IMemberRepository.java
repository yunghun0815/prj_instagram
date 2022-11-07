package com.kosa.instagram.member.dao;

import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {
	//회원가입(사진 x)
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	//파일 업로드
	public void insertFile(FileVo file);
	//비밀번호,닉네임, 핸드폰 번호 수정
	public void updateMember(MemberVo member);
	
}
