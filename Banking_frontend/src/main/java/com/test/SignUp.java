package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		//UserDao obj = new UserDao();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String name = fname+" "+lname;
		String pass = request.getParameter("pwd");
		String username = request.getParameter("user");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		double amount =  Double.parseDouble(request.getParameter("amount"));
		long phone = Long.parseLong(request.getParameter("phone"));
		
		user.setName(name);
		user.setPassword(pass);
		user.setUserName(username);
		user.setEmail(email);
		user.setPhn_no(phone);
		user.setAddress(address);
		user.setGender(gender);
		user.setAmount(amount);
		
		RequestDispatcher requestDispatcher;
		
		int chk = UserDao.saveUser(user);
		System.out.println("chk = "+chk);
		if(chk == 0) {
			System.out.println("Row not added ");
			requestDispatcher=request.getRequestDispatcher("register.html");
	        requestDispatcher.forward(request, response);
		}
		else {
			System.out.println("Row added");
			requestDispatcher=request.getRequestDispatcher("login.html");
	        requestDispatcher.forward(request, response);
		}
	
		
	
	}

}
