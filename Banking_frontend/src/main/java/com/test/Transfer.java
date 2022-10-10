package com.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
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
		String usr1_acc_no=null;
		String usr2 = null;
		System.out.println("user = "+usr);
		double transfer_amount = Double.parseDouble(request.getParameter("transfer_amount"));
		String usr2_accno = request.getParameter("accno");
		String name1 = null;
		long phone1 = 0;
		String email1=null;
		String trans_type=null;
		trans_type = request.getParameter("trans_type");
		String name2 = null;
		long phone2 = 0;
		String email2=null;
		
		double balance1 = 0;
		double balance2 = 0;
		int chk = 0;
		LocalDateTime myDateObj=null;
		
		String sql1 = "select * from user_details where username='"+ usr +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql1);
			if(rs.next()) {
			usr1_acc_no = rs.getString(4);
			name1 = rs.getString(1);
			phone1 = rs.getLong(8);
			email1 = rs.getNString(7);
			balance1 = rs.getDouble(5);
			System.out.println("balance retrieved of the user= "+balance1);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("user logged in : "+usr);
		System.out.println("user accno : "+usr1_acc_no);
		System.out.println("name = "+name1);
		System.out.println("phone = "+phone1);
		System.out.println("email = "+email1);
		
		
		if(transfer_amount<balance1) {
			
		String sql2 = "select * from user_details where acc_no='"+ usr2_accno +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql2);
			if(rs.next()) {
			usr2 = rs.getString(2);
			name2 = rs.getString(1);
			phone2 = rs.getLong(8);
			email2 = rs.getNString(7);
			balance2 = rs.getDouble(5);
			System.out.println("balance retrieved of reciptent = "+balance2);}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance2 = balance2 + transfer_amount;
		myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		
		System.out.println("Reciptent username  : "+usr2);
		System.out.println("Reciptent accno  : "+usr2_accno);
		System.out.println("Reciptent name = "+name2);
		System.out.println("Reciptent phone = "+phone2);
		System.out.println("Reciptent email = "+email2);
		String update_query = "update user_details set amount='"+balance2+"' where username='"+usr2+"';";
		try {
			chk = Util.getConnection().createStatement().executeUpdate(update_query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		balance1 = balance1 - transfer_amount;
		update_query = "update user_details set amount='"+balance1+"' where username='"+usr+"';";
		try {
			chk = Util.getConnection().createStatement().executeUpdate(update_query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(chk==1) {
			System.out.println("Transfer Complete from "+usr+" to "+usr2);
			System.out.println(name1+" new balance = "+balance1);
			System.out.println(name2+" new balance = "+balance2);
		}
		else {
			System.out.println("There was an error while updating balance");
		}
		String trans_sql = "insert into transaction(from_acc_no,to_acc_no,amount,trans_type,date_time)"+
		" values('"+usr1_acc_no+"','"+usr2_accno+"','"+transfer_amount+"','"+trans_type+"','"+formattedDate+"');";
		
		try {
			Statement stmt  = Util.getConnection().createStatement();
			stmt.executeUpdate(trans_sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Added to transaction table");
		System.out.println("");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("transfer.jsp");
//		requestDispatcher.forward(request, response);
		request.setAttribute("msg", "successfulTransaction");
		dispatcher=request.getRequestDispatcher("transfer.jsp");
		dispatcher.forward(request, response);
//		response.sendRedirect("http://localhost:7171/Banking_frontend/Login?username="+session.getAttribute("username")+
//				"&pwd="+session.getAttribute("password"));  

	}
		else {
			System.out.println("Insufficient funds in "+usr+ "Account");
			request.setAttribute("msg", "notEnoughFunds");
			dispatcher = request.getRequestDispatcher("transfer.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	

}
