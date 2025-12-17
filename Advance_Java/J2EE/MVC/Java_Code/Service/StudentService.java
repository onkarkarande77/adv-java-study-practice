package com.service;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.StudentDataBean;
import com.dao.Student_DAO;

/**
 * Servlet implementation class StudentService
 */
@WebServlet("/stud_service")
public class StudentService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student_DAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao=new Student_DAO();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//get the object from the session
		HttpSession session=request.getSession();
		StudentDataBean sbean=(StudentDataBean)request.getAttribute("stud");
		//connect with DAL layer
		boolean flag;
		if(dao.register_std_data(sbean))
		{
			out.print("success");
		    //session.invalidate();
		}
		else
			out.print("fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
