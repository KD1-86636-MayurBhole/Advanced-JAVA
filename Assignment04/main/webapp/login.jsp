<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<jsp:useBean id="l" class="com.sunbeam.beans.LoginBean"/>
<jsp:setProperty property="*" name="l"/>
${l.login()}
<c:choose>
<c:when test="${l.user==null}">
   <h2>Login Failed</h2>
   <p><a href='index.jsp'>Login Again</a></p>
</c:when>
<c:otherwise>
   <c:redirect url="newuser.jsp"/>	
</c:otherwise>
</c:choose>
</div>
</body>
</html>