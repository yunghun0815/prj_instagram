package com.kosa.instagram.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.member.dao.IMemberRepository;
import com.kosa.instagram.member.service.IMemberService;

@Service
public class MemberService implements IMemberService{
	
	@Autowired
	IMemberRepository memberRepository;
}
