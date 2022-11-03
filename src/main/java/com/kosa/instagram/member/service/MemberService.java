package com.kosa.instagram.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.member.dao.IMemberRepository;
import com.kosa.instagram.member.model.MemberVo;

@Service
public class MemberService implements IMemberService{
	
	@Autowired
	IMemberRepository memberRepository;

	@Override
	public void insertMember(MemberVo member) {
		System.out.println("¼­ºñ½º");
		memberRepository.insertMember(member);
	}

	@Override
	public MemberVo selectMember(String memberId) {
		return memberRepository.selectMember(memberId);
	}
}
