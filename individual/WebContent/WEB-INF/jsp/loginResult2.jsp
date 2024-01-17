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
<title>Tabter</title>
</head>
<body>
<h1>Tabterログイン</h1>
<% if(login != null) { %>
	<p>ログインに成功しました</p>
	<img src="ロゴ.jpg" alt="ロゴ" title="ロゴ"></img>
	<p>ようこそ <%= login.getName() %>さん、みんなとおいしいお店を教え合いましょう!</p>
	<a href="/tabettar/Main">メインへ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="/tabettar/">TOPへ</a>
<% } %>
</body>
</html>