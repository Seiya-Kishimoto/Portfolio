package model;

import javax.servlet.http.HttpSession;

import dao.AccountDAO;

public class LoginLogic {
	public Account execute(Login login){
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account;
	}

}
