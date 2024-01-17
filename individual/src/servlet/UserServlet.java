package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Account;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String errorMsg = "";
		String okMsg = "";


		if(name == null || name.length() == 0) {
			//エラーメッセージをリクエストスコープに保存
			errorMsg += "名前が入力されていません<br>";
		}if(pass == null || pass.length() == 0) {
			//エラーメッセージをリクエストスコープに保存
			errorMsg += "パスワードが入力されていません";
			request.setAttribute("errorMsg",errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/User.jsp");
			dispatcher.forward(request,response);
		}if(errorMsg.equals("")){
			//アプリケーションスコープに保存されたつぶやきリストを取得
			ServletContext application = this.getServletContext();
			List<Account> accountList = (List<Account>) application.getAttribute("accountList");

			//つぶやきをつぶやきリストに追加
			Account account = new Account(pass, name);
			UserDAO dao = new UserDAO();
			dao.create(account);

			//登録完了メッセージ表示
			System.out.println("ユーザー登録完了しました");
			okMsg = "ユーザー登録完了しました";
			request.setAttribute("okMsg",okMsg);

		}
		//
		//メイン画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserOK.jsp");
				dispatcher.forward(request,response);

	}

}
