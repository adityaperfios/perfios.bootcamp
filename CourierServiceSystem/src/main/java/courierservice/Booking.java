package courierservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		Details obj = new Details();
		LocalDate myDateObj = null;
		double basic=50;
		double dist_amount=0;
		double wt_amount=0;
		PrintWriter out = response.getWriter();
		String cust_name = request.getParameter("cust_name");
		long phone = Long.parseLong(request.getParameter("phone"));
		System.out.println("phone = "+phone);
		String city = request.getParameter("fromcity");
		String delivery_city = request.getParameter("tocity");
		double weight = Double.parseDouble(request.getParameter("weight"));
		RequestDispatcher dispatcher=null;
		myDateObj = LocalDate.now();
//		DateFormatter myFormatObj = DateFormatter.ofPattern("yyyy-MM-dd");
//		String formattedDate = myDateObj.format(myFormatObj);
		double rpg = obj.getRpg();
		obj.setCust_name(cust_name);
		obj.setPhn(phone);
		obj.setCity(city);
		obj.setDelivery_area(delivery_city);
		obj.setWt(weight);
		obj.setBook_date(myDateObj);
		
		
		wt_amount = rpg*weight;
		
		
		if (obj.getCity().equals("mumbai") && obj.getDelivery_area().equals("mumbai")){
			obj.setPay_amt(basic + wt_amount+200.00);
			obj.setDel_date(myDateObj.plusDays(1));
		}
		
		else if (obj.getCity().equals("mumbai") && obj.getDelivery_area().equals("bangalore")){
			obj.setPay_amt(basic + wt_amount+ 500.00) ;
			obj.setDel_date(myDateObj.plusDays(3));
		}
		
		else if (obj.getCity().equals("mumbai") && obj.getDelivery_area().equals("chennai")){
			obj.setPay_amt(basic + wt_amount+ 1000.00) ;
			obj.setDel_date(myDateObj.plusDays(4));
		}
		
		else if (obj.getCity().equals("mumbai") && obj.getDelivery_area().equals("delhi")){
			obj.setPay_amt(basic + wt_amount + 600.00) ;
			obj.setDel_date(myDateObj.plusDays(7));
		}
		
		
		
		else if (obj.getCity().equals("bangalore") && obj.getDelivery_area().equals("bangalore")){
			obj.setPay_amt(basic + wt_amount + 200.00) ;
			obj.setDel_date(myDateObj.plusDays(1));
		}
		
		else if (obj.getCity().equals("bangalore") && obj.getDelivery_area().equals("mumbai")){
			obj.setPay_amt(basic + wt_amount + 500.00) ;
			obj.setDel_date(myDateObj.plusDays(3));
		}
		else if (obj.getCity().equals("bangalore") && obj.getDelivery_area().equals("chennai")){
			obj.setPay_amt(basic + wt_amount + 300.00) ;
			obj.setDel_date(myDateObj.plusDays(1));
		}
		else if (obj.getCity().equals("bangalore") && obj.getDelivery_area().equals("delhi")){
			System.out.println("amount = "+basic + wt_amount + 900.00);
			System.out.println("del date = "+myDateObj.plusDays(7));
			obj.setPay_amt(basic + wt_amount + 900.00) ;
			obj.setDel_date(myDateObj.plusDays(7));
		}
		
		
		else if (obj.getCity().equals("chennai") && obj.getDelivery_area().equals("chennai")){
			obj.setPay_amt(basic + wt_amount + 200.00) ;
			obj.setDel_date(myDateObj.plusDays(1));
		}
		
		else if (obj.getCity().equals("chennai") && obj.getDelivery_area().equals("mumbai")){
			obj.setPay_amt(basic + wt_amount + 1000.00) ;
			obj.setDel_date(myDateObj.plusDays(3));
		}
		else if (obj.getCity().equals("chennai") && obj.getDelivery_area().equals("bangalore")){
			obj.setPay_amt(basic + wt_amount + 300.00) ;
			obj.setDel_date(myDateObj.plusDays(3));
		}
		
		else if (obj.getCity().equals("chennai") && obj.getDelivery_area().equals("delhi")){
			obj.setPay_amt(basic + wt_amount + 1000.00) ;
			obj.setDel_date(myDateObj.plusDays(7));
		}
		
		
		
		
		else if (obj.getCity().equals("delhi") && obj.getDelivery_area().equals("delhi")){
			obj.setPay_amt(basic + wt_amount + 200.00) ;
			obj.setDel_date(myDateObj.plusDays(1));
		}
		
		else if (obj.getCity().equals("delhi") && obj.getDelivery_area().equals("bangalore")){
			obj.setPay_amt(basic + wt_amount + 900.00) ;
			obj.setDel_date(myDateObj.plusDays(7));
		}
		else if (obj.getCity().equals("delhi") && obj.getDelivery_area().equals("mumbai")){
			obj.setPay_amt(basic + wt_amount + 600.00) ;
			obj.setDel_date(myDateObj.plusDays(6));
		}
		else if (obj.getCity().equals("delhi") && obj.getDelivery_area().equals("chennai")){
			obj.setPay_amt(basic + wt_amount + 1000.00) ;
			obj.setDel_date(myDateObj.plusDays(7));
		}
	
		int chk = DetailsDao.saveUser(obj);
		if(chk!=0) {
			request.setAttribute("msg", "successfulDeposit");
			dispatcher=request.getRequestDispatcher("index.jsp");
			
		}else {
			request.setAttribute("msg", "accountNotPresent");
			dispatcher=request.getRequestDispatcher("index.jsp");
			
		}
		dispatcher.forward(request, response);
	}
	}

