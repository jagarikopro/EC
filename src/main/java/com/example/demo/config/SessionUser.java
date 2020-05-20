package com.example.demo.config;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUser implements Serializable {
	
	private boolean userSession;

	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public boolean isUserSession() {
		return userSession;
	}

	public void setUserSession(boolean userSession) {
		this.userSession = userSession;
	}
	
	public void reset() {
		this.userSession =false;
	}

}
