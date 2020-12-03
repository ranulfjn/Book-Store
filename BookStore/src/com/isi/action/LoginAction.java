package com.isi.action;


import com.isi.entity.Users;
import com.isi.manager.*;
public class LoginAction {
	public static  Users validateUser(String email, String password)
	{
		return LoginManager.validateCredentials(email,password);
	}

}
