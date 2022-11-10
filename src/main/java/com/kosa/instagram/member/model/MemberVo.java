package com.kosa.instagram.member.model;

import java.sql.Date;

public class MemberVo {
	private String memberId;
	private String password;
	private String nickname;
	private String name;
	private String gender;
	private String email;
	private Date birth;
	private String phoneNumber;
	private int followerCount;
	private int fileNo;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", password=" + password + ", nickname=" + nickname + ", name=" + name
				+ ", gender=" + gender + ", email=" + email + ", birth=" + birth + ", phoneNumber=" + phoneNumber
				+ ", followerCount=" + followerCount + ", fileNo=" + fileNo + "]";
	}
}
