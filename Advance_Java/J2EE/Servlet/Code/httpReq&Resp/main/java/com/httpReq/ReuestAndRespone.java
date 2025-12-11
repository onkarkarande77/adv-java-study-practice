package com.httpReq;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ReuestAndRespone
 */
@WebServlet("/senddata")
public class ReuestAndRespone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReuestAndRespone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		//object for response on the web page
		PrintWriter out=response.getWriter();
		
		//getting data from the form
		String id=request.getParameter("user");
		String pass=request.getParameter("pwd");
		
		//now display the userId and pass after hitting the login button on next page
		out.print(" "+"user name:-"+id+" "+"password :-"+pass);
		
		
	}

}
