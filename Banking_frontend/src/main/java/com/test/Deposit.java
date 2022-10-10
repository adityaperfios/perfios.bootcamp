package com.test;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		User user = new User();
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		String usr = (String)session.getAttribute("username");
		System.out.println("user = "+usr);
		double deposit_amount = Double.parseDouble(request.getParameter("deposit_amount"));
		String name = null;
		long phone = 0;
		String email=null;
		double balance = 0;
		int chk = 0;
		LocalDateTime myDateObj = null;
		String acc =  (String) session.getAttribute("acc_no");
		String sql = "select * from user_details where username='"+ usr +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql);
			if(rs.next()) {
			name = rs.getString(1);
			phone = rs.getLong(8);
			email = rs.getNString(7);
			balance = rs.getDouble(5);
			System.out.println("balance retrieved = "+balance);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance = balance + deposit_amount;
		System.out.println("user logged in : "+usr);
		System.out.println("name = "+name);
		System.out.println("phone = "+phone);
		System.out.println("email = "+email);
		String update_query = "update user_details set amount='"+balance+"' where username='"+usr+"';";
		try {
			chk = Util.getConnection().createStatement().executeUpdate(update_query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(chk==1) {
			System.out.println("Balance Updated");
			myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDate = myDateObj.format(myFormatObj);
			
			String trans_sql = "insert into transaction(to_acc_no,amount,trans_type,date_time)"+
					" values('"+acc+"','"+deposit_amount+"','"+"CASH_IN"+"','"+formattedDate+"');";
			try {
				Statement stmt  = Util.getConnection().createStatement();
				stmt.executeUpdate(trans_sql);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Deposit successful");
			request.setAttribute("msg", "successfulDeposit");
			dispatcher=request.getRequestDispatcher("deposit.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("http://localhost:7171/Banking_frontend/Login?username="+session.getAttribute("username")+
//					"&pwd="+session.getAttribute("password"));  
		}
		else {
			System.out.println("There was an error while updating balance");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("404.html");
			requestDispatcher.forward(request, response);
		}
		System.out.println("");
	}

}
