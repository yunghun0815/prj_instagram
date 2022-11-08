package com.kosa.instagram.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.feed.model.FeedVo;
import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	List<MemberVo> searchListByKeyword(@Param("keyword") String keyword);
}
