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
<title>capture student data</title>
</head>
<body bgcolor="salmon" text="seagreen">
<form action="pages/stud_bean_store.jsp">

  <input type="text" name="stdId" placeholder="enter stud id"/>
  <input type="text" name="stdName" placeholder="enter stud name"/>
  <input type="submit" value="register"/>

</form>

</body>
</html>