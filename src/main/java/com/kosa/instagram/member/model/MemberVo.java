package com.kosa.instagram.member.model;

import java.sql.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class MemberVo {

   @Pattern(regexp="^[a-zA-Z0-9]{5,15}", message="{MEMBERID_MESSAGE}")
   private String memberId;
   
   @Pattern(regexp="(?=.*[0-9])(?=.[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
   message="��й�ȣ�� ���� ��/�ҹ��ڿ� ����, Ư����ȣ�� ��� 1�� �̻� ���Ե� 8~20�ڷ� ������ �ּ���.")
   private String password;
   
   @Pattern(regexp="^[a-zA-Z0-9~!@#$%^&*()-_=+]{4,20}", 
   message="�г����� ���� ��/�ҹ���, ���� �� Ư������(~!@#$%^&*()-_=+)�� �̷���� 8~20�ڷ� ������ �ּ���.")
   private String nickname;
   
   @Pattern(regexp="^[a-zA-Z��-�R]{2,20}", message="�̸��� ���� ��/�ҹ��ڿ� �ѱ۷� �̷���� 2�� �̻����� ������ �ּ���.")

   private String name;

   private String gender;
   
   @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "�̸��� ���Ŀ� ���� �ʽ��ϴ�.")
   private String email;
   
   @Past(message="��������� Ȯ���� �ּ���.")
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
   private Date birth;
   
   @Pattern(regexp="^[0-9]{11}", message="�ڵ��� ��ȣ��'-'�� ������ 11���� �̷���� ���ڸ� �Է����ּ���")

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