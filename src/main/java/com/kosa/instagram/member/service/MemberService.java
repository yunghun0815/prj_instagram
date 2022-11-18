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
		System.out.println("占쏙옙占쏙옙");
		memberRepository.insertMember(member);
	}

	@Override
	public MemberVo selectMember(String memberId) {
		return memberRepository.selectMember(memberId);
	}

	//硫ㅻ쾭�븘�씠�뵒瑜� 議고쉶�빐�꽌 feed_no媛� null�씠硫� �뾽�뜲�씠�듃, �
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

	//fileNo 議고쉶
	@Override
	public Integer selectFileNo(String memberId) {
		return memberRepository.selectFileNo(memberId);
	}

	//�쉶�썝�젙蹂� �궘�젣
	@Override
	public void deleteMember(MemberVo member) {
		memberRepository.deleteMember(member);
	}

	@Override
	public String getPassword(String password) {
		return memberRepository.getPassword(password);
	}

	@Override
	public String findMmeberId(String email) {
		return memberRepository.findMemberId(email);
	}

	@Override
	public String findPassword(String memberId, String email) {
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

	//아이디 중복체크
	public String checkId(String memberId) {
		return memberRepository.checkId(memberId);
	}
	public String checkNickname(String nickname) {
		return memberRepository.checkNickname(nickname);
	}
	public String checkEmail(String email) {
		return memberRepository.checkEmail(email);
	}
	@Override
	public void followMember(String fromId, String toId) {
		memberRepository.followMember(fromId, toId);
	}

	@Override
	public void unfollowMember(String fromId, String toId) {
		memberRepository.unfollowMember(fromId, toId);
	}
}