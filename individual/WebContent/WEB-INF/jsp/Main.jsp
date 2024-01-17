<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login,model.Mutter,model.Account,java.util.List" %>
<%
//セクションスコープからユーザー情報を取得
Login login = (Login) session.getAttribute("login");
Account account = (Account) session.getAttribute("account");
//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList = (List<Mutter>) session.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tabetter</title>
<style type="text/css">
.contentA{
 width: 500px;
}

.contentB{
width: 500px;


}

.coment{
width: 500px;
 height: 680px;
 white-space:normal;
 overflow:visible scroll;

}

.comentL{
width: 475px;
 display: inline-block;
 background-color: #ffffff;
 border: 1px solid skyblue;
}

h2{
text-align:center

}

.a{
}

.b{
	display: inline-block;
	vertical-align: middle;
	color: blue;
	font-weight: bold;
	text-decoration: none;
	background-color: #ffffff;
	border: 1px solid blue;
	cursor: pointer;
}

.c{
	vertical-align: middle;
}



.main{
 display: flex;
}
</style>
</head>
<body>
<div class="main">
	<div class="contentA">
	<h1>Tabetter<img src="ロゴミニ.jpg" alt="ロゴミニ" title="ミニはらぺこあおどり"></img></h1>
		<p>
		<%= login.getName() %>さん、ログイン中<br>
		</p>
		<h3>お店入力欄</h3>
		<form action="/tabettar/Main" method="post">
		カテゴリ:
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
		店舗名:<br>
		<input type="text" name="store"><br>
		感想:<br>
		<textarea name="memo"></textarea><br>
		評価:<br>
		<input type="radio" name="star" value="★1">★1
		<input type="radio" name="star" value="★2">★2
		<input type="radio" name="star" value="★3">★3
		<input type="radio" name="star" value="★4">★4
		<input type="radio" name="star" value="★5">★5<br>
<!-- 		写真挿入:<br>
		<input type="file"  name="pop"><br>
-->
		<input type="submit" value="入力"><br>
		</form>
		<form action="/tabettar/ProfileServlet" method="post">
				<input type="hidden" name="user_id" value="<%= account.getUserId() %>">
				<input type="submit" value="プロフィール入力＆編集" class="a">
		</form>
		<a href="/tabettar/Logout">ログアウト</a>


		<% if(errorMsg != null) {%>
		<p><%= errorMsg %></p>
		<% } %>
	</div>
	<div class="contentB">
	<h2>お店紹介コメント</h2>
		<div class="coment">
		<% if(mutterList != null){ %>
		<% for(Mutter mutter : mutterList) {%>
		<div class="comentL">
				<form action="/tabettar/ProfileServlet" method="post">
				<input type="hidden" name="user_id" value="<%= mutter.getUserId() %>">
				<input type="submit" value="<%= mutter.getUserName() %>" class="b"><b>さんの紹介</b>
				　　　<%= mutter.getTime() %><br></form><p>
				カテゴリ：<%= mutter.getQtype() %><br>
				店舗名：<%= mutter.getStore() %><br>
				感想：<%= mutter.getMemo() %><br>
				評価：<%= mutter.getStar() %></p>

				<% if(account.getUserId() == mutter.getUserId()) {%>
					<form action="/tabettar/DeleteServlet" method="post" class="c">
					<input type="hidden" name="delete_id" value="<%= mutter.getId() %>">
					<input type="submit" value="削除"><br>
					</form>
		</div>
		<% }}} %>
		</div>
	</div>
</div>
</body>
</html>