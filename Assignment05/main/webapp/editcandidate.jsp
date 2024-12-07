<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 20px; padding: 20px; background-color: #f4f4f9; color: #333;">
    <h2 style="text-align: center; color: #4CAF50;">Edit Candidate</h2>
    <jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean"/>
    <jsp:setProperty name="fcb" property="candId" param="id" />
    ${fcb.findCandidate()}
    <form method="post" action="updatecand.jsp" style="max-width: 400px; margin: auto; padding: 20px; background: #fff; border: 1px solid #ccc; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
        <input type="hidden" name="id" value="${fcb.cand.id}"/>
        
        <label for="name" style="display: block; margin-top: 10px; font-weight: bold;">Name:</label>
        <input type="text" id="name" name="name" value="${fcb.cand.name}" 
               style="width: calc(100% - 20px); padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px;"/>
        
        <label for="party" style="display: block; margin-top: 10px; font-weight: bold;">Party:</label>
        <input type="text" id="party" name="party" value="${fcb.cand.party}" 
               style="width: calc(100% - 20px); padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px;"/>
        
        <label for="votes" style="display: block; margin-top: 10px; font-weight: bold;">Votes:</label>
        <input type="text" id="votes" name="votes" readonly="readonly" value="${fcb.cand.votes}" 
               style="width: calc(100% - 20px); padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; background-color: #f9f9f9;"/>
        
        <input type="submit" value="Update" 
               style="width: 100%; padding: 10px; margin-top: 20px; border: none; border-radius: 4px; background-color: #4CAF50; color: white; font-size: 16px; cursor: pointer;"/>
    </form>    
</body>
</html>
