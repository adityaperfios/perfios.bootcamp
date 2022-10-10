package com.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int chk = 0;
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		String user = (String) session.getAttribute("username");
		String email = request.getParameter("updateEmail");
		String phone = request.getParameter("updatePhone");
		String address = request.getParameter("updateAddress");
		String password = request.getParameter("updatePassword");
		String sql = "UPDATE user_details SET password='"+password+"', email = '"+email+"', address= '"+address+"', phone_no = '"+phone+"' WHERE username = '"+user+"';";
		try {
			chk = Util.getConnection().createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(chk!=0) {
			session.setAttribute("password", password);
			request.setAttribute("msg", "successfulEdit");
			dispatcher=request.getRequestDispatcher("edit.jsp");
//			response.sendRedirect("http://localhost:7171/Banking_frontend/Login?username="+session.getAttribute("username")+
//					"&pwd="+session.getAttribute("password"));
		}
		else {
			request.setAttribute("msg", "failEdit");
			dispatcher=request.getRequestDispatcher("edit.jsp");
			System.out.println("Updation Failed");
		}
		dispatcher.forward(request, response);
	}

}
