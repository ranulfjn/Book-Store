package com.isi.manager;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.isi.entity.Books;

public class SessionManager {
	
	public static void  addToSession(HttpServletRequest req , Map<Integer, Books> bookHash) {
		HttpSession session = req.getSession();
		session.setAttribute("Session", bookHash);
		
	}
	
	public static void  removeSession(HttpServletRequest req , String id) {
		HttpSession session = req.getSession();
		if(session.getAttribute(id) != null) {
			session.removeAttribute(id);
		}
	
	}
	
	public static ArrayList<Books> getBookList(HttpServletRequest req){
		ArrayList<Books> listOfBooks = new ArrayList<Books>();
		
		HttpSession session = req.getSession();
		
		Enumeration<String> getAttribute =  session.getAttributeNames();
		
		if(getAttribute != null) {
			
			while(getAttribute.hasMoreElements()) {
				String element = getAttribute.nextElement();
				Books book = (Books)session.getAttribute(element);
				listOfBooks.add(book);
			}
		}
		return listOfBooks;
		
	}

}
