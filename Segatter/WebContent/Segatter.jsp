<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Segaat" %>

<%
// セッションスコープからユーザー情報を取得
User user = (User) session.getAttribute("user");
ArrayList<Segaat> segaatList = (ArrayList<Segaat>)request.getAttribute("segaatList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>segatter</title>
</head>
<body>
<p>ログインc:<%= user.getId() %></p>
<a href="http://google.com">ログアウト（未実装）</a>
<% for(Segaat segaat : segaatList){ %>
<p><%= segaat.getComment()  %> <br>:from-<%= segaat.getAuther() %></p>
<br>
<% } %>
</body>
</html>