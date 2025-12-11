package com.login_auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.image.ReplicateScaleFilter;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//checking the credentials
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		
		if(user.equals("java") && pwd.equals("spring")) {
			//if authentication successful,then set the session attribute
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			
			//forward to landing page
			response.sendRedirect("pages/home.jsp");
		}
		else {
			response.sendRedirect("pages/login-form.jsp?type=0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
