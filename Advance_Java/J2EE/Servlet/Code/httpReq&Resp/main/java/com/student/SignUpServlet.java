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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	ResultSet rs;
	//PreparedStatement prp;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		
		
          		
		//get data from the SignUp
        String name=request.getParameter("user");
        String pass=request.getParameter("pwd");
        String gender=request.getParameter("gender");
        
        String[] course = request.getParameterValues("course_id");
       
        String courseIds = String.join(",", course);;
//         for(String co:course) {
//        	 coId=co;
//        	 System.out.println(coId);
//         }
         String countryId=request.getParameter("country_id");
        
        MySqlDbConn ds=new MySqlDbConn();
        conn=ds.getConn();
      
       try { 
        
    	/*//we push country into the our table and take there id from the table
        String coqry="select * from course where course_name=?";
        PreparedStatement prpCourse=conn.prepareStatement(coqry);
        prpCourse.setString(1,cour);
        ResultSet rsCourse=prpCourse.executeQuery();
        
        int courseId=0;
        if(rsCourse.next()) {
        	courseId=rsCourse.getInt("course_id");
        	}
        	
       //now we take the country from the user and push into table and getting there id
        	String conqry="select * from country where country_name=?";
        	PreparedStatement prpCountry=conn.prepareStatement(conqry);
        	prpCountry.setString(1,country);
        	ResultSet rsCountry=prpCountry.executeQuery();
        	
        	int countryId=0;
        	if(rsCountry.next()) {
        		countryId=rsCountry.getInt("country_id");
        	}
        	
       //finally we take all the above reff and push all the details into the student table
        	String qry="insert into student (name,pass,gender,course_id,country_id) values (?,?,?,?,?)";
        	PreparedStatement prp=conn.prepareStatement(qry);
        	 prp.setString(1,name);
        	 prp.setString(2,pass);
        	 prp.setString(3,gender);
        	 prp.setInt(4,courseId);
        	 prp.setInt(5, countryId);
        	 
        	 *
        	 */
        	  
    	   String sql = "INSERT INTO student (name, pass, gender, course_id, country_id) VALUES (?, ?, ?, ?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);

           ps.setString(1, name);
           ps.setString(2, pass);
           ps.setString(3, gender);
           ps.setInt(4, Integer.valueOf(courseIds));
           ps.setInt(5, Integer.parseInt(countryId));

           int row = ps.executeUpdate();
        	if(row>0) {
        		 out.println("<h3>Signup Successful!</h3>");
        	 }
        	 else {
        		 out.println("<h3>Something went wrong!</h3>");
        	 }
      	
       }
       catch(Exception e) {
        	e.printStackTrace();
        }
       finally {
		System.out.println("done");
	}
        
        
        
        
	
	}
}

