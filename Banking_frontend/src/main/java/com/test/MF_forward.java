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
 * Servlet implementation class MF_forward
 */
@WebServlet("/MF_forward")
public class MF_forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String mf_id = request.getParameter("mf_id");
		System.out.println("id="+mf_id);
		String name = null;
		double min_balance = 0;
		double f_size = 0;
		String f_type = null;
		float nav = 0;
		float returns = 0;
		
		String sql = "select * from MF_inv where fund_id='"+ mf_id +"';";
		
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql);
			System.out.println("result set created ");
			if(rs.next()) {
			name = rs.getString(2);
			returns = rs.getFloat(4);
			f_type = rs.getString(5);
			f_size = rs.getDouble(6);
			min_balance = rs.getDouble(3);
			nav = rs.getFloat(7);
			//System.out.println("balance retrieved = "+balance);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
							}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
			session.setAttribute("fund_id",mf_id);
			session.setAttribute("fund_name", name);
			session.setAttribute("return", returns);
			session.setAttribute("type", f_type);
			session.setAttribute("min", min_balance);
			session.setAttribute("size", f_size);
			session.setAttribute("nav", nav);
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("mf_form.jsp");
			rd.forward(request, response);

		}
	}

