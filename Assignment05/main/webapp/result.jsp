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
table { width: 80%; border-collapse: collapse; margin: 20px auto; background-color: #fff; }
th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }
th { background-color: #007bff; color: white; }
tr:nth-child(even) { background-color: #f2f2f2; }
a { text-decoration: none; color: #007bff; }
a:hover { text-decoration: underline; }
h2 { text-align: center; color: #333; }
hr { margin: 20px auto; width: 80%; }
</style>
</head>
<body>
<div class='container'>
<jsp:useBean id="l" class="com.sunbeam.beans.CandidateBean"/>
<jsp:setProperty property="*" name="l"/>
${l.fetchCandidate()}
<h2>Voting Result</h2>
<table>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Party</th>
<th>Votes</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="c" items="${l.candlist}">
  <tr>
  <td>${c.id}</td>
  <td>${c.name }</td>
  <td>${c.party}</td>
  <td>${c.votes}</td>
  <td>
      <a href='editcandidate.jsp?id=${c.id}'><img src='images/edit.png' alt='Edit' width='24' height='24'/></a>
      <a href='delete.jsp?id=${c.id}'><img src='images/delete.png' alt='Delete' width='24' heigth='24'/></a>
  </td>
  </tr>
</c:forEach>
</tbody>
</table>
</form>
</div>
</body>
</html>