package courierservice;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import courierservice.Util;

/**
 * Servlet implementation class Track
 */
@WebServlet("/Track")
public class Track extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		String id = request.getParameter("track_id");
		
		int pid;
		String name;
		String from;
		long phone;
		String to;
		double wt;
		Date book_date;
		Date del_date;
		double amount;
		
		String sql1 = "select * from courier_details where track_id='"+ id +"';";
		try {
			ResultSet rs = Util.getConnection().createStatement().executeQuery(sql1);
			if(rs.next()) {
			pid = rs.getInt(1);
			name = rs.getString(2);
			from = rs.getString(3);
			phone = rs.getLong(4);
			to = rs.getString(5);
			wt = rs.getDouble(6);
			book_date = rs.getDate(8);
			del_date = rs.getDate(9);
			amount = rs.getDouble(10);
			System.out.println("info fetched");
			System.out.println("name = "+name);
			System.out.println("phone = "+phone);
			request.setAttribute("id", pid);
			request.setAttribute("name", name);
			request.setAttribute("from", from);
			request.setAttribute("phone", phone);
			request.setAttribute("to", to);
			request.setAttribute("wt", wt);
			request.setAttribute("book_date", book_date);
			request.setAttribute("del_date", del_date);
			request.setAttribute("amount", amount);
			
			request.setAttribute("msg", "successTracking");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			}
			//out.print(" <script> document.getElementById(\"phone_number\").innerHTML ="+ phone+";"+"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql exception");
			request.setAttribute("msg", "failedTracking");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("unknown exception");
			request.setAttribute("msg", "failedTracking");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
//		System.out.println("outside try ");
//		request.setAttribute("msg", "failedTracking");
//		dispatcher=request.getRequestDispatcher("index.jsp");
//		dispatcher.forward(request, response);
	}

}
