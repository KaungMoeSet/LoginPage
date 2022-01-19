<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // for Http 1.1 versoin
	
	response.setHeader("Pragma", "no-cache"); // for Http 1.0 older version
	
	response.setHeader("Expires", "0"); // for Proxies
	
	if( session.getAttribute("name")== null){
			response.sendRedirect("/LoginPage/login.jsp");	
	}
		%>
	Hello Nice to meet you ${name}
	<a href="/LoginPage/videos.jsp">Videos here</a>
	
	<form action="LogOut">
		<input type="submit" value="Logout">
	</form>
</body>
</html>