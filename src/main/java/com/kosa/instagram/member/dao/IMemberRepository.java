package com.kosa.instagram.member.dao;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {
	
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
}
