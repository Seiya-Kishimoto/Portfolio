<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login,model.Mutter,model.Account,model.Profile,java.util.List" %>
 <%
//セクションスコープからユーザー情報を取得
Login login = (Login) session.getAttribute("login");
Account account = (Account) session.getAttribute("account");
Profile profile = (Profile) session.getAttribute("profile");
List<Mutter> mutterList = (List<Mutter>) session.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabetterプロフィール</title>
</head>
<body>
<h1>Tabetterプロフィール<img src="ロゴミニ.jpg" alt="ロゴミニ" title="ミニはらぺこあおどり"></img></h1>

		<p><%= profile.getUserName() %>さんのプロフィール<br>
				好物カテゴリ：<%= profile.getQtype() %><br>
				好物　　　　：<%= profile.getFood() %><br>
				お気に入り店：<%= profile.getStore() %><br>
				一言　　　　：<%= profile.getComent() %><br></p>


		<% if(profile.getId() == account.getUserId()){ %>
			<form action="/tabettar/Profile2Servlet" method="post">
				<input type="hidden" name="id" value="<%= account.getUserId() %>">
				好物カテゴリ※必須:
				<select name="qtype">
					<option value="--">--</option>
					<option value="和食">和食</option>
					<option value="中華">中華</option>
					<option value="洋食">洋食</option>
					<option value="ラーメン">ラーメン</option>
					<option value="うどん・そば">うどん・そば</option>
					<option value="鍋">鍋</option>
					<option value="カレー">カレー</option>
					<option value="焼肉">焼肉</option>
					<option value="その他">その他</option>
				</select><br>
				好物※必須:
				<input type="text" name="food"><br>
				お気に入り店:
				<input type="text" name="store"><br>
				一言:<br>
				<textarea name="coment"></textarea><br>
				<input type="submit" value="入力＆編集"><br>
			</form>

		<% } %>
		<p><a href="/tabettar/Main">メインへ</a></p>
		<a href="/tabettar/Logout">ログアウト</a>

</body>
</html>