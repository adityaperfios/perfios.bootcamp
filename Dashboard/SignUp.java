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
		response.setContentType("text/html");
		response.setContentType("text/html");// to get request from html to java
		
		PrintWriter out = response.getWriter();//to print data on browser
		User user = new User();
		//UserDao obj = new UserDao();
		
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String username1 = request.getParameter("user");
		String password = request.getParameter("pwd");
		String email =  request.getParameter("Email");
		String phone = request.getParameter("Phone");
		String gender = request.getParameter("inlineRadioOptions");
		String address = request.getParameter("address");
		try {
            RequestDispatcher requestDispatcher;
 
            // path is a string specifying the pathname to
            // the resource. If it is relative, it must be
            // relative against the current servlet
            requestDispatcher=request.getRequestDispatcher("path");
            requestDispatcher.forward(request, response);
        }
        catch (ServletException servletException) {
        }
        catch (IOException ioException) {
        }
        catch (IllegalStateException illegalStateException) {
        }
		if(password != null) {
//			out.println("Registration Success");
//			out.println("first name = "+firstname);
//			out.println("last name = "+lastname);
//			out.println("user = "+user);
//			out.println("password = "+password);
//			out.println("Email = "+email);
//			out.println("phone = "+phone);
//			out.println("gender = "+gender);
//			out.println("address = "+address);
			firstname = firstname.concat(" ");
			String name = firstname.concat(lastname);
			user.setName(name);
			user.setPassword(password);
			user.setUserName(username1);
			user.setAddress(address);
			user.setGender(gender);
			user.setPhn_no(Long.parseLong(phone));
			user.setEmail(email);
			UserDao.saveUser(user);
		}
		else {
			out.println("Registration failed");
		}
	}

}
