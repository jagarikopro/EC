package com.example.demo.service;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.dbflute.exception.EntityAlreadyDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dbflute.exbhv.UserBhv;
import com.example.demo.dbflute.exentity.User;
import com.example.demo.dto.UserForm;

@Service
public class AuthserviceImpl implements AuthService {

	@Autowired
	private UserBhv userBhv;

	@Override
	public int checkUser(UserForm userForm) {

		try {
			User user = userBhv.selectEntityWithDeletedCheck(cb -> {
				cb.query().setEmail_Equal(userForm.getEmail());
			});
			if(user != null){
				String userPassword = decode(user.getPassword(),ENCKEY,IVEC,CHARSET);
				if(userPassword.equals(userForm.getPassword())) {
					return user.getUserId();
				}
			}
		
		} catch (EntityAlreadyDeletedException e) {
			throw new NotFoundException("ユーザーが存在しません");
		}
		//該当のユーザが存在しない場合0を返す
		return 0;
	}

	@Override
	public String encode(String str, String encKey, String iVec, String charset) {

		try {
			SecretKeySpec key = new SecretKeySpec(encKey.getBytes(charset), "AES");
			IvParameterSpec iv = new IvParameterSpec(iVec.getBytes(charset));

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			byte[] byteResult = cipher.doFinal(str.getBytes(charset));

			return Base64.getEncoder().encodeToString(byteResult);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String decode(String str, String encKey, String iVec, String charset) {

		try {
			SecretKeySpec key = new SecretKeySpec(encKey.getBytes(charset), "AES");
			IvParameterSpec iv = new IvParameterSpec(iVec.getBytes(charset));

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, iv);
			byte[] byteResult = cipher.doFinal(Base64.getDecoder().decode(str));

			return new String(byteResult, charset);
		} catch (Exception e) {
		}
		return null;
	}

}
