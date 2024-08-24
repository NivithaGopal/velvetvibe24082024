<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <% 
 	String email=request.getParameter("email");
 	String password=request.getParameter("password");
 	
 	if(email.equals("administrator@gmail.com") && password.equals("Admin*54321")){
 		request.getRequestDispatcher("admin.jsp").forward(request, response);
 	}else{
 		request.getRequestDispatcher("user.jsp").forward(request, response);
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>