package com.kosa.instagram.member.service;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberService {
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	
	

}
