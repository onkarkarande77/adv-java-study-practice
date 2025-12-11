package com.student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.MySqlDbConn;

/**
 * Servlet implementation class StdLogin
 */
@WebServlet("/login")

public class StdLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn;
	PreparedStatement prp;
	ResultSet rs;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StdLogin() {
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
	   //user enter data
	    String id=request.getParameter("user");
	    String pwd=request.getParameter("pwd");
	    
	    String qry="select std_id,std_pass from std_detail where std_id=? and std_pass=?";
	    
	    RequestDispatcher rd;
	    MySqlDbConn ds=new MySqlDbConn();
	    conn=ds.getConn();
	    try {
			prp=conn.prepareStatement(qry);
			prp.setInt(1,Integer.parseInt(id));
			prp.setString(2,pwd);
			
			rs=prp.executeQuery();
			
			if(rs.next()) {
				rd=request.getRequestDispatcher("stddata");
				rd.forward(request, response);
		     }
			else {
				rd=request.getRequestDispatcher("loginform.html");
				rd.include(request, response);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
