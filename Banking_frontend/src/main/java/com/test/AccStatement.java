package com.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccStatement
 */
@WebServlet("/AccStatement")
public class AccStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String usr1_acc_no = (String) session.getAttribute("acc_no");
		RequestDispatcher rd;
		boolean flag = false;
		String sql2 = "SELECT * FROM transaction where from_acc_no='"+usr1_acc_no +"' or "
				+ "to_acc_no='"+usr1_acc_no+"' order by date_time desc;";
		
		ArrayList<ArrayList> Rows = new ArrayList<ArrayList>();
		try {
			int count=0;
			ResultSet rs1 = Util.getConnection().createStatement().executeQuery(sql2);
			while(rs1.next()) {
					ArrayList row = new ArrayList();
					row.add(rs1.getInt(1));
					row.add(rs1.getInt(2));
					row.add(rs1.getInt(3));
					row.add(rs1.getDouble(4));
					row.add(rs1.getString(5));
					row.add(rs1.getTimestamp(6));
					
					Rows.add(row);
				}
			}
	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		if(Rows.isEmpty()) {
			flag=false;
		}else {
			flag=true;
		}
		if(flag) {
			
		request.setAttribute("statement", Rows);
		rd = request.getRequestDispatcher("AccStatement.jsp");
		rd.forward(request, response);

		}
		else {
			request.setAttribute("msg", "cantGetStatement");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
