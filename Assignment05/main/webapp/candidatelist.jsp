<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body { font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 20px; }
.container { max-width: 600px; margin: 20px auto; background: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; }
h2 { color: #333; margin-bottom: 20px; }
form { margin-top: 20px; }
input[type='radio'] { margin-right: 10px; }
input[type='submit'] { padding: 10px 20px; background-color: #007BFF; color: #fff; border: none; border-radius: 5px; cursor: pointer; }
input[type='submit']:hover { background-color: #0056b3; }
</style>
</head>
<body>
<div class='container'>
<jsp:useBean id="l" class="com.sunbeam.beans.CandidateBean"/>
<jsp:setProperty property="*" name="l"/>
${l.fetchCandidate()}
<h1>${session }</h1>
<h2>Candidates List</h2>
<form method="post" action="vote.jsp">
<c:forEach var="c" items="${l.candlist}">
  <input type="radio" name="candidateId" value="${c.id }"/>${c.name }-${c.party}<br/>
</c:forEach>
<br/><input type='submit' value='Vote'/>
</form>
</div>
</body>
</html>