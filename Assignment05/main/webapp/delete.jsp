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
<jsp:useBean id="v" class="com.sunbeam.beans.DeleteBean" />
<jsp:setProperty property="candId" name="v" param="id"/>
${v.delete()}
<c:choose >
      <c:when test="${v.result!=0}">
          <h2>Something went wrong</h2>
          <p><a href='result.jsp'>Retry</a></p>
      </c:when>
      <c:otherwise>
          <h2>Candidate Deleted</h2>
          <p><a href='result.jsp'>View List</a></p>
      </c:otherwise>
   </c:choose>
</div>
</body>
</html>