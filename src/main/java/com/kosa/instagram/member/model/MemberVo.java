package com.kosa.instagram.member.model;

import java.sql.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class MemberVo {
	@Pattern(regexp="^[a-zA-Z0-9]{5,15}", message="아이디는 영문 대/소문자, 숫자를 이용해 5~10로 설정해 주세요.")
	private String memberId;
	
	@Pattern(regexp="(?=.*[0-9])(?=.[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
	message="비밀번호는 영문 대/소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8~20자로 설정해 주세요.")
	private String password;
	
	@Pattern(regexp="^[a-zA-Z0-9~!@#$%^&*()-_=+]{4,20}", 
	message="닉네임은 영어 대/소문자, 숫자 및 특수문자(~!@#$%^&*()-_=+)로 이루어진 8~20자로 설정해 주세요.")
	private String nickname;
	
	@Pattern(regexp="^[a-zA-Z가-힣]{2,20}", message="이름은 영어 대/소문자와 한글로 이루어진 2자 이상으로 설정해 주세요.")
	private String name;

	private String gender;
	
	@Email(message="이메일 형식에 맞지 않습니다.")
	private String email;
	
	@Past(message="생년월일을 확인해 주세요.")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date birth;
	
	@Pattern(regexp="^[0-9]{11}", message="핸드폰 번호는'-'를 제외한 숫자만 입력해주세요")
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
