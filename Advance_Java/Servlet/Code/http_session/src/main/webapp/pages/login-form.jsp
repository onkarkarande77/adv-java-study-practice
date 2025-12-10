<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body bgcolor='cyan' text='maroon'>
<%
   if(request.getParameter("type").equals("0")){
	   out.print("invalid credentials,please login again");
   }
%>
 <form action="auth">
   <input type="text" name="user" value="" placeholder="enter your name"/>
     <input type="password" name="pwd"  placeholder="password"/>
     <input type="submit" value="login here"/>
 </form>

</body>
</html>