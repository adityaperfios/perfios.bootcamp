package com.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StoreInvestment
 */
@WebServlet("/StoreInvestment")
public class StoreInvestment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		double amount = Double.parseDouble((String)request.getParameter("inv_amount"));
		System.out.println("In in StoreInvestment");
		System.out.println("min = "+session.getAttribute("min"));
		
		double min = (double) session.getAttribute("min");
		float returns = (float) session.getAttribute("return");
		int id = Integer.parseInt((String)session.getAttribute("fund_id")) ;
		
		String usr = (String)session.getAttribute("username");
		String acc = (String)session.getAttribute("acc_no");
		String fund_name = (String)session.getAttribute("fund_name");
		RequestDispatcher rd;
		double balance=0;
		int chk=0;
		String sql = "select * from user_details where username='"+ usr +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql);
			if(rs.next()) {
			//name = rs.getString(1);
			//phone = rs.getLong(8);
			//email = rs.getNString(7);
			balance = rs.getDouble(5);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fetched balance = "+balance);
		if(amount<min) {
			request.setAttribute("msg", "belowMinimum");
			rd = request.getRequestDispatcher("mf_form.jsp");
		}
		else if(amount<balance){
		LocalDateTime myDateObj = null;
		myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		
		String sql1 = "insert into user_inv(fund_id,time,inv_amount,cur_amount,account_no,fund_name)"+
				" values('"+id+"','"+formattedDate+"','"+amount+"','"+amount+"','"+acc+"','"+fund_name+"');";
		try {
			Statement stmt  = Util.getConnection().createStatement();
			stmt.executeUpdate(sql1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserted in user_inv table");
		balance = balance - amount;
		String update_query = "update user_details set amount='"+balance+"' where username='"+usr+"';";
		try {
			chk = Util.getConnection().createStatement().executeUpdate(update_query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Updated balance in user table");
		String trans_sql = "insert into transaction(from_acc_no,amount,trans_type,date_time)"+
				" values('"+acc+"','"+amount+"','"+"INVESTMENT"+"','"+formattedDate+"');";
				
				try {
					Statement stmt  = Util.getConnection().createStatement();
					stmt.executeUpdate(trans_sql);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println("transaction table updated");
		request.setAttribute("msg", "successINV");
		rd = request.getRequestDispatcher("mf_form.jsp");
		rd.forward(request, response);
		
		}
		else {
			request.setAttribute("msg", "insufficientFunds");
			rd = request.getRequestDispatcher("mf_form.jsp");
			rd.forward(request, response);
		}
	}

}
