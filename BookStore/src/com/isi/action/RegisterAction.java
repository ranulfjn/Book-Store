package com.isi.action;

import com.isi.manager.UserRegisterManager;

public class RegisterAction {

	public static boolean registerUser(String userName, String email, String password) {
		return UserRegisterManager.addUser(userName, email, password);
	}
}
