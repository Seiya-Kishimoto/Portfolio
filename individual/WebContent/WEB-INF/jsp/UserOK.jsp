<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//リクエストスコープに保存されたッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
String okMsg = (String) request.getAttribute("okMsg");
%>
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
<h1>Tabetter新規ユーザー登録完了</h1>

<% if(okMsg != null) {%>
		<p><%= okMsg %></p>
		<% } %>
<a href="/tabettar/">トップへ</a>
</div>
</body>
</html>