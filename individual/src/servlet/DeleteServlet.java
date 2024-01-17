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

import dao.DeleteDAO;
import model.GetMutterListLogic;
import model.Mutter;




@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータの取得
		request.setCharacterEncoding("UTF-8");
		String delete_id = request.getParameter("delete_id");
		//int id = Integer.parseInt(delete_id);


		DeleteDAO dao = new DeleteDAO();
		dao.delete(delete_id);


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
