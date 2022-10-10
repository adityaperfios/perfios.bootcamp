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
 * Servlet implementation class Withdraw
 */
@WebServlet("/WithdrawPage")
public class WithdrawPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();
		//Util obj = new Util();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		String usr = (String)session.getAttribute("username");
		//String pass = (String)session.getAttribute("password");
		System.out.println("user = "+usr);
		double withdraw_amount = Double.parseDouble(request.getParameter("withdraw_amount"));
		double balance=0;
		String acc =  (String) session.getAttribute("acc_no");
		String name = null;
		long phone = 0;
		String email=null;
		int chk=0;
		LocalDateTime myDateObj = null;
		//System.out.println("username = "+usr);
		String sql = "select * from user_details where username='"+ usr +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql);
			if(rs.next()) {
			name = rs.getString(1);
			phone = rs.getLong(8);
			email = rs.getNString(7);
			balance = rs.getDouble(5);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(withdraw_amount>balance) {
			request.setAttribute("msg","notEnoughBalance");
			dispatcher=request.getRequestDispatcher("withdraw.jsp");
			System.out.println("Error : Can't withdraw more than "+balance);
		}
		else {
			balance = balance - withdraw_amount;
			String update_query = "update user_details set amount='"+balance+"' where username='"+usr+"';";
			try {
				chk = Util.getConnection().createStatement().executeUpdate(update_query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(chk==1) {
			System.out.println("Balance Updated");
			System.out.println("user account number "+acc);
			myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDate = myDateObj.format(myFormatObj);
			
			String trans_sql = "insert into transaction(from_acc_no,amount,trans_type,date_time)"+
					" values('"+acc+"','"+withdraw_amount+"','"+"CASH_OUT"+"','"+formattedDate+"');";
			try {
				Statement stmt  = Util.getConnection().createStatement();
				stmt.executeUpdate(trans_sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("withdraw.jsp");
//			requestDispatcher.forward(request, response);
			request.setAttribute("msg", "successfulWithdraw");
			dispatcher=request.getRequestDispatcher("withdraw.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("http://localhost:7171/Banking_frontend/Login?username="+session.getAttribute("username")+
//					"&pwd="+session.getAttribute("password"));  
		}
		else {
			System.out.println("chk = "+chk);
			System.out.println("There was an error while updating balance");
			dispatcher.forward(request, response);
		}
		System.out.println("");
		System.out.println("name = "+name);
		System.out.println("phone = "+phone);
		System.out.println("email = "+email);
		
	}

}
