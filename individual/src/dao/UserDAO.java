package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Account;


public class UserDAO {
	private final String JDBC_URL =
			"jdbc:mysql://localhost/tabettar";
	private final String DB_USER = "root";
	private final String DE_PASS = "";

	public boolean create(Account Account) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DE_PASS)){

			String sql = "INSERT INTO ACCOUNT(NAME, PASS) VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, Account.getName());
			pStmt.setString(2, Account.getPass());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
	}

}
