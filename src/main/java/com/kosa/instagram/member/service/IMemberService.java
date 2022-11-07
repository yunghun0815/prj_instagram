package com.kosa.instagram.member.service;

import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IMemberService {
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	
	//업데이트
	public void updateMember(MemberVo member, FileVo file);
	
	public void updateMember(MemberVo member);

}
