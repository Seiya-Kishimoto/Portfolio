<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//リクエストスコープに保存されたッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
String okMsg = (String) request.getAttribute("okMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabetter新規ユーザー登録</title>
<style type="text/css">
.main{
text-align:center
}
</style>
</head>
<body>
<div class="main">
<h1>Tabetter新規ユーザー登録</h1>
<form action="/tabettar/UserServlet" method="post">
ユーザー名<input type="text" name="name"><br>
パスワード<input type="password" name="pass"><br>
<input type="submit" value="新規登録"><br>
<a href="/tabettar/">トップへ</a>

<% if(errorMsg != null) {%>
		<p><%= errorMsg %></p>
		<% } %>
<% if(okMsg != null) {%>
		<p><%= okMsg %></p>
		<% } %>
</div>
</body>
</html>