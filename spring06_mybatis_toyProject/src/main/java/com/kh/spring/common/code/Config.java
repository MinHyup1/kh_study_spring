package com.kh.spring.common.code;

public enum Config {
	//DOMAIN("http://pclass.ga")
	DOMAIN("http://localhost:8989"),
	COMPANY_EMAIL("p01073027511@gmail.com"),
	STMP_AUTHENTICATION_ID("p01073027511@gmail.com"),
	STMP_AUTHENTICATION_PASSWORD("k75117511"),
	UPLOAD_PATH("/usr/local/toy/upload/");
	//UPLOAD_PATH("C:\\CODE\\upload\\");
	
	
	public final String DESC;
	
	private Config(String desc) {
		this.DESC = desc;
	
	}
}
