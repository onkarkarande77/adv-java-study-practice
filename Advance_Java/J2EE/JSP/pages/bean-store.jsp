<%@page import="com.mysql.cj.jdbc.MysqlDataSource"%>
<%@page import="com.servlet.revise.MySqlDbConn"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER DETAIL</title>
</head>
<body bgcolor="pink" text="red">

 <jsp:useBean id="cust" class="com.cust.CustomerBean">
 
 <!-- set value from the HTML -->
 <jsp:setProperty name="cust" param="custId" property="custId"/>
 <jsp:setProperty name="cust" param="custName" property="custName"/>
 
 <!-- get value from the user entered  -->
 <h3>CUSTOMER DATA</h3>
 <jsp:getProperty name="cust" property="custId"/>
 <jsp:getProperty name="cust" property="custName"/>
 
 ${cust.custId}
 ${cust.custName} 
 </jsp:useBean>
 
 <%
     Connection conn;
     PreparedStatement prp;
     MysqlDataSource ds;
     String qry="insert into cust values(?,?)";
     
     try{
    	 ds=new MysqlDataSource();
    	 
    	 ds.setUser("root");
    	 ds.setPassword("pass@123");
    	 ds.setServerName("localhost");
    	 ds.setDatabaseName("revise");
    	 ds.setPort(3306);
    	 
    	 conn=ds.getConnection();
    	 
    	 String id=request.getParameter("custId");
    	 String name=request.getParameter("custName");
    	 
    	 prp=conn.prepareStatement(qry);
    	 
    	 prp.setInt(1,Integer.parseInt(id));
    	 prp.setString(2,name);
    	 
    	 int row=prp.executeUpdate();
    	 if(row>0){
    		 System.out.println("success");
    	 }
    	 
    	 
    	 
     }catch(SQLException e){
    	 e.printStackTrace();
     }
 
 
 %>
 
 <%
   FileWriter fw=null;
    
 try{   
	 String filePath ="E:\\Servlet_Practice\\web_revise\\data\\cust.txt";
	 fw = new FileWriter(filePath, true);
	 //fw=new FileWriter("cust.txt",true);
   String id=request.getParameter("custId");
   String name=request.getParameter("custName");
   
   System.out.println(id);
   System.out.println(name);
   
   fw.write(id+"#"+name+"\n");
    
 }catch(Exception e){
	 e.printStackTrace();
 }
 finally{
	 try{
		 fw.close();
	 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 %>
</body>
</html>