package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	private final String JDBC_URL =
			"jdbc:mysql://localhost/tabettar";
	private final String DB_USER = "root";
	private final String DE_PASS = "";

		public List<Mutter> findAll(){
			List<Mutter> mutterList = new ArrayList<>();

			//データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DE_PASS)){

				//SELECT分を準備
				String sql = "SELECT ID, NAME, QTYPE, STORE, MEMO, STAR, TIME, USER_ID FROM MUTTER ORDER BY ID DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery();

				//結果表に格納されたレコードの内容を
				//インスタンスに設定し、ArrayListインスタンスに追加
				while (rs.next()) {
					int id = rs.getInt("ID");
					String userName = rs.getString("NAME");
					String qtype = rs.getString("QTYPE");
					String store = rs.getString("STORE");
					String memo = rs.getString("MEMO");
					String star = rs.getString("STAR");
					String time = rs.getString("TIME");
					int userId = rs.getInt("USER_ID");
					Mutter mutter = new Mutter(id, userName, qtype, store, memo, star, time, userId);
					mutterList.add(mutter);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;

			}
			return mutterList;
		}

		public boolean create(Mutter mutter) {
			//データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DE_PASS)){

				String sql = "INSERT INTO MUTTER(NAME, QTYPE, STORE, MEMO, STAR, TIME,USER_ID) VALUES(?,?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);




				pStmt.setString(1, mutter.getUserName());
				pStmt.setString(2, mutter.getQtype());
				pStmt.setString(3, mutter.getStore());
				pStmt.setString(4, mutter.getMemo());
				pStmt.setString(5, mutter.getStar());
				pStmt.setString(6, mutter.getTime());
				pStmt.setInt(7, mutter.getUserId());

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
