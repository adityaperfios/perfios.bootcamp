package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileAction
 */
@WebServlet("/ProfileAction")
public class ProfileAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String op = request.getParameter("operation");
		RequestDispatcher requestDispatcher;
		if(op.equals("Edit")) {
			requestDispatcher=request.getRequestDispatcher("edit.jsp");
            requestDispatcher.forward(request, response);
			
		}
		else if(op.equals("Delete")) {
			requestDispatcher=request.getRequestDispatcher("delete.jsp");
            requestDispatcher.forward(request, response);
		
	}

	}
}
