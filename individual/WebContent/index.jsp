<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>Tabetterへ参加</h1>
	<img src="ロゴ.jpg" alt="ロゴ" title="はらぺこあおどり"></img>
	<form action="/tabettar/LoginServlet" method="post">
	ユーザー名<input type="text" name="name"><br>
	パスワード<input type="password" name="pass"><br>
	<input type="submit" value="ログイン">
	</form>
	<a href="/tabettar/UserServlet">新規ユーザー登録はこちら</a>
</div>
</body>
</html>