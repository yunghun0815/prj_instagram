package com.kosa.instagram.member.dao;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {
	MemberVo selectMember(String memberId);

}
