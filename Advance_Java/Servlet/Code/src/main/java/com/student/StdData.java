package com.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.MySqlDbConn;

/**
 * Servlet implementation class StdData
 */
@WebServlet("/stddata")
public class StdData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement prp;
	ResultSet rs;
	String qry="select std_detail.std_name,std_detail.std_pass,course.course_name,country.country_name from std_detail inner join course_detail on (std_detail.std_id=course_detail.std_id) inner join course on (course_detail.course_id=course.course_id) inner join country_detail on (std_detail.std_id=country_detail.std_id) inner join country on (country_detail.country_id=country.country_id) where std_detail.std_id=?";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public StdData() {
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
		
		PrintWriter out=response.getWriter();
		//get login detail 
		String id=request.getParameter("user");
		
		//get db connection and executing the prp
		MySqlDbConn ds=new MySqlDbConn();
		
		conn=ds.getConn();
		try {
			prp=conn.prepareStatement(qry);
			prp.setInt(1,Integer.parseInt(id));
			rs=prp.executeQuery();
			
			out.println("<html><body>");
			out.println("<h2>Student Detail</h2>");
			out.println("<table border='2' cellpadding='10'>");
			out.println("<tr><th>Name</th><th>Password</th><th>Course</th><th>Country</th></tr>");
			
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("</tr>");
			}
			
			out.println("</table><br></br>");
			out.println("<a href"+"="+"update"+">"+"updatedata"+"</a>");
			out.println("</body></html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
