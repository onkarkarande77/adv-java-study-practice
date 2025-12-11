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
<title>click here to login</title>
</head>
<body bgcolor='skyblue' text='seagreen'>
<a href="pages/login-form.jsp?type=1"><h3>Login here</h3></a>

</body>
</html>