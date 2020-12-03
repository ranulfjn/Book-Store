package com.isi.manager;
import com.isi.service.*;


import java.sql.*;
import java.util.ArrayList;

import com.isi.entity.Users;


public class LoginManager {
	
	static String  query="select * from userLogin where email=? and password=?";

	
	public static  Users validateCredentials(String email,String password)
	{
		//Users Obj= new Users(0,null,email,password);
		//ArrayList<Users> list = new ArrayList<Users>();
		Users  user=null;
		
		
		try {
			
			PreparedStatement ps = DatabaseConnection.getPreparedStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
	
			ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				  user = new Users(
						rs.getInt("userID"),
						rs.getString("userName"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("level")
							);
				return user;
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

}
