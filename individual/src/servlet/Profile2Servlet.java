package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDAO;
import model.Account;
import model.Login;
import model.Profile;


@WebServlet("/Profile2Servlet")
public class Profile2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String qtype = request.getParameter("qtype");
				String food = request.getParameter("food");
				String store = request.getParameter("store");
				String coment = request.getParameter("coment");
				String errorMsg = "";


				if(qtype.equals("--") ) {
					//エラーメッセージをリクエストスコープに保存
					errorMsg += "好きな食べ物カテゴリが入力されていません<br>";
				}if( food == null || food.length() == 0) {
					//エラーメッセージをリクエストスコープに保存
					errorMsg += "好きな食べ物が入力されていません<br>";
					request.setAttribute("errorMsg",errorMsg);
				}if(errorMsg.equals("")) {
					//セッションスコープに保存されたつぶやきリストを取得
					HttpSession session = request.getSession();
					//セッションスコープに保存されたユーザー情報を取得
					Account account = (Account) session.getAttribute("account");

					//つぶやきをつぶやきリストに追加
					Profile profile = new Profile(account.getUserId(), qtype, food, store, coment);
					ProfileDAO dao = new ProfileDAO();
					dao.create(profile);

					//アプリケーションスコープにつぶやきリストを保存
					//application.setAttribute("mutterList", mutterList);
				}

				//つぶやきリストを取得して、リクエストスコープに保存
				HttpSession session = request.getSession();
				Account account = (Account) session.getAttribute("account");
				ProfileDAO dao = new ProfileDAO();
				Profile profile = dao.findAll(id);
				session.setAttribute("profile", profile);



				//メイン画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
				dispatcher.forward(request,response);
	}

}
