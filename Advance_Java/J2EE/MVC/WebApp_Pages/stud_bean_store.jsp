<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String path1="/stud_service";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>injecting form data into java bean</title>
</head>
<body>
 <jsp:useBean id="stud" class="com.bean.StudentDataBean" scope="session">
 <jsp:setProperty name="stud" param="stdId" property="stdId"/>
 <jsp:setProperty name="stud" param="stdName" property="stdName"/>

</jsp:useBean>
<jsp:forward page ="<%=path1 %>"></jsp:forward>


</body>
</html>