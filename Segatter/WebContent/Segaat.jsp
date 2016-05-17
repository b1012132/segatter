<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Segaat here</title>
</head>
<body>
<% java.util.Date today = new java.util.Date(); %>
<form action="/Segatter/SegaatController" method="post">
セガートする内容<input type="text" name="text"><br>
<input type="submit" value="セガートする"><br>
<input type="hidden" name="date" value=<%= today.toString() %>>
<input type="hidden" name="auther" value="SEGAWA">
</form>
</body>
</html>