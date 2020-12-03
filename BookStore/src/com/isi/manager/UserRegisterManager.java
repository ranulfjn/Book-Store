package com.isi.manager;
import com.isi.entity.*;
import java.sql.*;
import com.isi.service.DatabaseConnection;
public class UserRegisterManager {
	
	static String query ="insert into userLogin(username,email,password) values(?,?,?)";
	public static boolean addUser(String userName,String email,String password)
	{
		PreparedStatement ps = DatabaseConnection.getPreparedStatement(query);
		try {
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return true;
	}
	
}
