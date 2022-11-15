package com.kosa.instagram.member.dao;


import java.util.List;


import com.kosa.instagram.feed.model.FileVo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.feed.model.FeedVo;

import com.kosa.instagram.member.model.MemberVo;

public interface IMemberRepository {


	MemberVo selectFeedMemberInfo(String memberId);
	List<String> selectFollowerByUser(String memberId);
	List<String> selectFollowByUser(String memberId);

	//�쉶�썝媛��엯(�궗吏� x)
	public void insertMember(MemberVo member);
	
	public MemberVo selectMember(String memberId);
	//�봽濡쒗븘�궗吏� �벑濡�
	public void insertFile(FileVo file);
	//�봽濡쒗븘�궗吏� �닔�젙
	public void updateFile(FileVo file);
	
	public Integer selectFileNo(String memberId);
	//鍮꾨�踰덊샇,�땳�꽕�엫, �빖�뱶�룿 踰덊샇 �닔�젙
	public void updateMember(MemberVo member);
	
	//�쉶�썝�젙蹂� �궘�젣
	public void deleteMember(MemberVo member);
	
	public String getPassword(String password);
	

	//�씠硫붿씪�쓣 �씠�슜�빐�꽌 �븘�씠�뵒 李얘린
	public MemberVo findMemberId(String email);
	
	//硫ㅻ쾭�븘�씠�뵒�옉 �뙣�뒪�썙�뱶 蹂댁뿬以섏빞 �븯怨� �븘�씠�뵒�� �씠硫붿씪 �씠�슜
	public MemberVo findPassword(@Param("memberId") String memberId, @Param("email")String email);

	void followMember(@Param("fromId")String fromId, @Param("toId")String toId);
	void unfollowMember(@Param("fromId")String fromId, @Param("toId")String toId);
}
