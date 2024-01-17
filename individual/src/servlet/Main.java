package servlet;

//import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.GetMutterListLogic;
import model.Login;
import model.Mutter;
import model.PostMutterLogic;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter>mutterList = getMutterListLogic.execute();
		//セッションスコープの宣言
		HttpSession session = request.getSession();
		session.setAttribute("mutterList", mutterList);

		//ログインしているか確認するためセクションスコープからユーザー情報を取得
		Login login = (Login) session.getAttribute("login");

		if(login == null) {//ログインしていない場合
			//リダイレクト
			response.sendRedirect("/memoapp/");
		} else {//ログイン済みの場合



			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Main.jsp");
			dispatcher.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String memo = request.getParameter("memo");
		String qtype = request.getParameter("qtype");
		String store = request.getParameter("store");
		String star = request.getParameter("star");
		String errorMsg = "";

		//現在時刻を文字列で入手
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String time = sdf.format(date);

		if(qtype.equals("--") ) {
			//エラーメッセージをリクエストスコープに保存
			errorMsg += "カテゴリが入力されていません<br>";
		}if(store == null || store.length() == 0) {
			//エラーメッセージをリクエストスコープに保存
			errorMsg += "店舗名が入力されていません<br>";
		}if(memo == null || memo.length() == 0) {
			//エラーメッセージをリクエストスコープに保存
			errorMsg += "感想が入力されていません<br>";
		}if(star == null || star.length() == 0) {
			//エラーメッセージをリクエストスコープに保存
			errorMsg += "評価が入力されていません";
			request.setAttribute("errorMsg",errorMsg);
		}if(errorMsg.equals("")) {
			//セッションスコープに保存されたつぶやきリストを取得
			HttpSession session = request.getSession();
			List<Mutter> mutterList = (List<Mutter>) session.getAttribute("mutterList");


			//セッションスコープに保存されたユーザー情報を取得
			Login login = (Login) session.getAttribute("login");
			Account account = (Account) session.getAttribute("account");

			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(login.getName(), qtype, store, memo, star, time, account.getUserId());
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);

			//アプリケーションスコープにつぶやきリストを保存
			//application.setAttribute("mutterList", mutterList);
		}

		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter>mutterList = getMutterListLogic.execute();
		HttpSession session = request.getSession();
		session.setAttribute("mutterList", mutterList);



		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Main.jsp");
		dispatcher.forward(request,response);

	}

}

