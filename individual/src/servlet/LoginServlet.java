package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		//ログイン処理の実行
		Login login = new Login(pass,name);
		LoginLogic bo = new LoginLogic();
		Account account = bo.execute(login);


		if(account != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("name", name);

			//ユーザー情報をセクションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setAttribute("account", account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			dispatcher.forward(request,response);
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResultNG.jsp");
				dispatcher.forward(request,response);
		}
	}

}
