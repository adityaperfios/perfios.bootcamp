package com.test;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String pass = request.getParameter("pwd");
		User user = new User();
		UserDao obj = new UserDao();
		String usr1_acc_no=null;
//		System.out.println("user = "+username);
		String name1 = null;
		String phone1 = null;
		String email1=null;
		String address1=null;
		
		int acc_no=0;
		double balance1=0;
		try {
            RequestDispatcher requestDispatcher;
 
            // path is a string specifying the pathname to
            // the resource. If it is relative, it must be
            // relative against the current servlet
            HttpSession session = request.getSession();
            boolean login_flag = false;
            login_flag = UserDao.login(username, pass);
            session.setAttribute("status", login_flag);
            if(login_flag) {
            System.out.println(login_flag);
			session.setAttribute("username",username);
			session.setAttribute("password", pass);
			
			String sql1 = "select * from user_details where username='"+ username +"';";
			try {
				ResultSet rs = Util.getConnection().createStatement().executeQuery(sql1);
				if(rs.next()) {
//					acc_no = rs.getInt(1);
				usr1_acc_no = rs.getString(4);
				name1 = rs.getString(1);
				phone1 = rs.getString(8);
				email1 = rs.getNString(7);
				balance1 = rs.getDouble(5);
				address1 = rs.getString(6);
				//System.out.println("balance retrieved of the user= "+balance1);}
				//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
				
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql2 = "SELECT * FROM transaction where from_acc_no='"+usr1_acc_no+"' or "
					+ "to_acc_no='"+usr1_acc_no+"' order by date_time desc limit 0,5;";
			
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
				e.printStackTrace();}
			
			ArrayList<ArrayList> Inv_Rows = new ArrayList<ArrayList>();
			String sql3 = "SELECT * FROM user_inv where account_no='"+usr1_acc_no+"' order by time desc limit 0,5;";
			try {
				int count=0;
				ResultSet rs2 = Util.getConnection().createStatement().executeQuery(sql3);
				while(rs2.next()) {
						ArrayList row = new ArrayList();
						
						row.add(rs2.getString(7));
						row.add(rs2.getDouble(5));
						Inv_Rows.add(row);
					}
				}
		
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			
			
			
			request.setAttribute("investments", Inv_Rows);
			request.setAttribute("transaction", Rows);
            session.setAttribute("name", name1);
            session.setAttribute("acc_no", usr1_acc_no);
            session.setAttribute("balance", balance1);
            session.setAttribute("email", email1);
            session.setAttribute("phone", phone1);
            session.setAttribute("address", address1);
			requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
            System.out.println("logged in as : "+username);
            }
            else {
            	System.out.println("status :"+login_flag);
            	String error = "Wrong username or password";
            	request.setAttribute("error", error);
            	requestDispatcher=request.getRequestDispatcher("404.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        catch (ServletException servletException) {
        }
        catch (IOException ioException) {
        }
        catch (IllegalStateException illegalStateException) {
        }
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}