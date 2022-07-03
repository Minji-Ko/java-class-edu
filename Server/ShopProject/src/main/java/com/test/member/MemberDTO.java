package com.test.member;

import lombok.Data;

@Data
public class MemberDTO {

	private String seq;
	private String gradeSeq;
	private String id;
	private String pw;
	private String name;
	private String address;
	private String tel;
	private String smsConsent;
	private String email;
	private String emailConsent;
	
	private String solarLunar;
	private String birthdate;
	private String footSize;
}
