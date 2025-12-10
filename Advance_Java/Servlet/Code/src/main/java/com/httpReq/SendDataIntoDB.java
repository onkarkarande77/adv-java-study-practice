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
import java.sql.SQLException;

import com.conn.MySqlDbConn;

/**
 * Servlet implementation class SendDataIntoDB
 */
@WebServlet("/insertDB")
public class SendDataIntoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement prp;
	String qry="insert into customer values(?,?)";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendDataIntoDB() {
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
		//get data from the user
		String id=request.getParameter("user");
		String name=request.getParameter("pwd");
		
		//make connection with DB to push data
		MySqlDbConn ds=new MySqlDbConn();
		conn=ds.getConn();
		try {
			prp=conn.prepareStatement(qry);
			prp.setInt(1,Integer.parseInt(id));
			prp.setString(2, name);
			int row=prp.executeUpdate();

			if(row>0) {
				out.print("Login successfully ,data send into DB");
			}
			
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
