package com.example.demo.service;

import com.example.demo.dto.UserForm;

public interface AuthService {

	public static final String ENCKEY = "5149754258746258";
	public static final String IVEC = "1234567890123456";
	public static final String CHARSET = "UTF-8";

    public int checkUser(UserForm userForm);

    public String encode(String str, String encKey, String iVec, String charset);

    public String decode(String str, String encKey, String iVec, String charset);

}
