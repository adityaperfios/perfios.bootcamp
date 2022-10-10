package com.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetCurrentUser
 */
@WebServlet("/GetCurrentUser")
public class GetCurrentUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
////		User user = new User();
		System.out.println("Servlet called");
		HttpSession session = request.getSession();
		String usr = (String)session.getAttribute("username");
		int id = Integer.parseInt(request.getParameter("id"));
		String usr1_acc_no=null;
		System.out.println("user = "+usr);
		String name1 = null;
		String phone1 = null;
		String email1=null;
		
		double balance1 = 0;
		int chk = 0;
		String sql1 = "select * from user_details where username='"+ usr +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql1);
			if(rs.next()) {
			usr1_acc_no = rs.getString(4);
			name1 = rs.getString(1);
			phone1 = rs.getString(8);
			email1 = rs.getNString(7);
			balance1 = rs.getDouble(5);
			System.out.println("balance retrieved of the user= "+balance1);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("name", name1);
		request.setAttribute("email", email1);
		request.setAttribute("phone", phone1);
		System.out.println("id = "+id);
		if(id==1) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("deposit.jsp");
		requestDispatcher.forward(request, response);}
		else if(id==2) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("withdraw.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(id==3) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("transfer.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
