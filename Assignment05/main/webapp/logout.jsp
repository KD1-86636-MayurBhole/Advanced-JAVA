<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<style>
body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 20px;}
.container { max-width: 400px; margin: 50px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; text-align: center; }
h2 { color: #e74c3c; }
p{ color: #555; }
a{ color: #007BFF; text-decoration: none; }
a:hover { text-decoration: underline; }
</style>
</head>
<body>
<div class='container'>
	<h2>Thank You</h2>
	<% session.invalidate(); %>
	
	<p>You are successfully logged out.</p>
	
	<p>
	<a href="index.jsp">Login Again</a>
	</p>
</div>
</body>
</html>