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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String pwd = request.getParameter("del_pwd");
		String pwd2 = request.getParameter("del_pwd2");
		String username = (String)session.getAttribute("username");
		boolean flag = false;
		int chk =0;
		if(pwd.equals(pwd2)){
			String sql1 = "select * from user_details where username='"+ username +"';";
			try {
				ResultSet rs = Util.getConnection().createStatement().executeQuery(sql1);
				if(rs.next()) {
//					acc_no = rs.getInt(1);
				String pass = rs.getString(3);
				if(pass.equals(pwd2)) {
					flag = true;
				}
				//System.out.println("balance retrieved of the user= "+balance1);}
				//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
				
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag) {
			String sql2 = "delete from user_details where username='"+username+"';";
			try {
				chk = Util.getConnection().createStatement().executeUpdate(sql2);
				if(chk!=0) {
					System.out.println("Account deleted");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
					requestDispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				System.out.println("Deletion can't happen at the moment");
			}
		}
		else {
			
		}
	}

}
