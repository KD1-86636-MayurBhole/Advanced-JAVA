<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="r" class="com.sunbeam.beans.RegisterBean"/>
<jsp:setProperty property="*" name="r"/>
${r.registerUser()}
<c:choose>
<c:when test="${result!=0}">
   <p>Registration Succesfull</p>
</c:when>
<c:otherwise>
   <p>something went wrong</p>
</c:otherwise>
</c:choose>
</body>
</html>