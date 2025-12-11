package com.httpReq;

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
 * Servlet implementation class FetchDataFromDB
 */
@WebServlet("/view")
public class FetchDataFromDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement prp;
	ResultSet rs;
	String qry="select * from customer";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchDataFromDB() {
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
		
		MySqlDbConn ds=new MySqlDbConn();
		conn=ds.getConn();
		try {
			prp=conn.prepareStatement(qry);
			rs=prp.executeQuery();
			
			//starting of the html logic
			//first we declare head and the column 
			out.println("<html><body>");
			out.println("<h2>Customer Records</h2>");
			out.println("<table border='1' cellpadding='10'>");
			out.println("<tr><th>Id</th><th>Name</th></tr>");
			
			//now injecting the db values into the our html table
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("</tr");
			}
			out.println("</table>");
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
