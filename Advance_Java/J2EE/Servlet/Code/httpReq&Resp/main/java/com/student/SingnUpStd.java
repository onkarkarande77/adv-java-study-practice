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

import com.conn.MySqlDbConn;

/**
 * Servlet implementation class SingnUpStd
 */
@WebServlet("/signupstd")
public class SingnUpStd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection conn;
       //PreparedStatement prp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingnUpStd() {
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
		
		//get data from the client
		String std_name=request.getParameter("user");
		String pass=request.getParameter("pwd");
		String gender=request.getParameter("gender");
		String[] courseId=request.getParameterValues("course_id");
		String countryId=request.getParameter("country_id");
		
		
		MySqlDbConn ds=new MySqlDbConn();
		conn=ds.getConn();
		PrintWriter out=response.getWriter();
		try{//now one by one we push it into db
		
		String qryMaster="insert into std_detail (std_name,std_pass,gender) values(?,?,?)";
		PreparedStatement prpMaster=conn.prepareStatement(qryMaster);
		prpMaster.setString(1,std_name);
		prpMaster.setString(2,pass);
		prpMaster.setString(3, gender);
		
		int r1=prpMaster.executeUpdate();
		if(r1>0) {
			System.out.println("Done in master");
		}
		
		//read data from the master for the taking the id
		String qry="select std_id from std_detail where std_name=?";
		PreparedStatement prp=conn.prepareStatement( qry);
		prp.setString(1,std_name);
		ResultSet rs=prp.executeQuery();
		int stdId=0;
		if(rs.next()) {
			stdId=rs.getInt(1);
		}
		
		
		
		//for the course_detail
		String qryCourse="insert into course_detail values(?,?)";
		PreparedStatement prpCourse=conn.prepareStatement(qryCourse);
		int co=0;
		for(String co_Id:courseId) {
		    prpCourse.setInt(1,stdId);
			prpCourse.setInt(2,Integer.parseInt(co_Id));
			
			co+=prpCourse.executeUpdate();
		}
		
		if(co>0) {
			System.out.println("done course");
		}
		
		
		//for country
		String qryCountry="insert into country_detail values(?,?)";
		PreparedStatement prpCountry=conn.prepareStatement(qryCountry);
		prpCountry.setInt(1,stdId);
		prpCountry.setInt(2,Integer.parseInt(countryId));
		int cn=prpCountry.executeUpdate();
		
		if(cn>0) {
			System.out.println("done country");
		}
		
		out.println("<h2>Status</h2>");
		if(r1>0 && co>0 && cn>0) {
			out.println("<h2>SignUp Successfully");
		}
		
		else {
			out.println("<h2>Fail To SignUp</h2>");
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
