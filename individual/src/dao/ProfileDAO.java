package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Mutter;
import model.Profile;

public class ProfileDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost/tabettar";//URL
	private final String DB_USER = "root";//USER
	private final String DE_PASS = "";//PASS


	public Profile findAll(String user_id){
//		List<Profile> profileList = new ArrayList<>();
		Profile profile = null;

		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DE_PASS)){

			//SELECT分を準備
			String sql = "SELECT USER_ID, NAME, QTYPE, FOOD, STORE, COMENT FROM ACCOUNT WHERE USER_ID =" + user_id + ";";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を
			//インスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String userName = rs.getString("NAME");
				String qtype = rs.getString("QTYPE");
				String food = rs.getString("FOOD");
				String store = rs.getString("STORE");
				String coment = rs.getString("COMENT");
				profile = new Profile(id, userName, qtype, food, store, coment);
//				profileList.add(profile);
				System.out.println(profile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
		return profile;
	}

	public boolean create(Profile profile) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DE_PASS)){

			String sql = "UPDATE ACCOUNT SET QTYPE = ?, FOOD = ?, STORE = ?, COMENT = ? WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, profile.getQtype());
			pStmt.setString(2, profile.getFood());
			pStmt.setString(3, profile.getStore());
			pStmt.setString(4, profile.getComent());
			pStmt.setInt(5, profile.getId());

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
