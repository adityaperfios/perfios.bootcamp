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
 * Servlet implementation class Investment
 */
@WebServlet("/MFInvestment")
public class MFInvestment extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		System.out.println("I'm here(mfInvestment)");
        HttpSession session = request.getSession();
		String usr1_acc_no = (String) session.getAttribute("acc_no");
		RequestDispatcher rd;
		boolean flag = false;
		String sql2 = "SELECT * FROM MF_inv;";
		
		ArrayList<ArrayList> Rows = new ArrayList<ArrayList>();
		try {
			ResultSet rs1 = Util.getConnection().createStatement().executeQuery(sql2);
			System.out.println("Resultset created");
			while(rs1.next()) {
					System.out.println("Inside loop");
					ArrayList row = new ArrayList();
					row.add(rs1.getInt(1));
					row.add(rs1.getString(2));
					row.add(rs1.getDouble(3));
					row.add(rs1.getFloat(4));
					row.add(rs1.getString(5));
					row.add(rs1.getDouble(6));
					row.add(rs1.getFloat(7));
					
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
			System.out.println("Row is not empty");
		request.setAttribute("funds", Rows);
		rd = request.getRequestDispatcher("MFDisplay.jsp");
		rd.forward(request, response);

		}
		else {
			request.setAttribute("msg", "cantGetStatement");
			rd = request.getRequestDispatcher("InvestmentMenu.jsp");
			rd.forward(request, response);
		}

	}

}
