<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login" %>
<%
//セクションスコープからユーザー情報を取得
Login login = (Login) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabetter</title>
<style type="text/css">
.main{
text-align:center
}
</style>
</head>
<body>
<div class="main">
	<h1>Tabetterへようこそ</h1>
	<img src="教え合い.jpg" alt="教え合い" title="はらぺこあおどりの教え合い"></img>
	<p>ようこそ <%= login.getName() %>さん、みんなとおいしいお店を教え合いましょう!</p>
	<a href="/tabettar/Main">メインへ</a>
</div>
</body>
</html>