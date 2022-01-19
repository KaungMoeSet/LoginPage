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
		<iframe width="560" height="315" src="https://www.youtube.com/embed/BBJa32lCaaY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</body>
</html>