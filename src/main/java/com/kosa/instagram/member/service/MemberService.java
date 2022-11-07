package com.kosa.instagram.member.service;

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

	//멤버아이디를 조회해서 파일이 있으면 업데이트, 없으면 인서트
	@Override
	public void updateMember(MemberVo member, FileVo file) {
		memberRepository.insertFile(file);
		memberRepository.updateMember(member);
	}

	@Override
	public void updateMember(MemberVo member) {
		memberRepository.updateMember(member);
	}


}
