package com.kosa.instagram.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.feed.model.FileVo;
import com.kosa.instagram.member.dao.IMemberRepository;
import com.kosa.instagram.member.model.MemberVo;

@Service
public class MemberService implements IMemberService{

	@Autowired
	IMemberRepository memberRepository;

	@Override
	public void insertMember(MemberVo member) {
		System.out.println("����");
		memberRepository.insertMember(member);
	}

	@Override
	public MemberVo selectMember(String memberId) {
		return memberRepository.selectMember(memberId);
	}

	//멤버아이디를 조회해서 feed_no가 null이면 업데이트, 없으면 인서트
	@Override
	public void updateMember(MemberVo member, FileVo file) {
		if (file != null && file.getFileNo()==0) {
			System.out.println("insert file ");
			memberRepository.insertFile(file);
		}
		else{
			System.out.println("update file");
			memberRepository.updateFile(file);
			
		}
		memberRepository.updateMember(member);
	}

	@Override
	public void updateMember(MemberVo member) {
		memberRepository.updateMember(member);
	}

	//fileNo 조회
	@Override
	public Integer selectFileNo(String memberId) {
		return memberRepository.selectFileNo(memberId);
	}

	//회원정보 삭제
	@Override
	public void deleteMember(MemberVo member) {
		memberRepository.deleteMember(member);
	}

	@Override
	public String getPassword(String password) {
		return memberRepository.getPassword(password);
	}

	@Override
	public MemberVo findMmeberId(String email) {
		return memberRepository.findMemberId(email);
	}

	@Override
	public MemberVo findPassword(String memberId, String email) {
		return memberRepository.findPassword(memberId, email);
	}

	@Override
	public MemberVo selectFeedMemberInfo(String memberId) {
		return memberRepository.selectFeedMemberInfo(memberId);
		
	}

	@Override
	public List<MemberVo> selectFollowerByUser(String memberId) {
		return memberRepository.selectFollowerByUser(memberId);
	}

	@Override
	public List<MemberVo> selectFollowByUser(String memberId) {
		return memberRepository.selectFollowByUser(memberId);
	}
	
	
}
