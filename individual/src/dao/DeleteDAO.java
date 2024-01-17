package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servlet.DeleteServlet;



public class DeleteDAO {
	private final String JDBC_URL =
			"jdbc:mysql://localhost/tabettar";
	private final String DB_USER = "root";
	private final String DE_PASS = "";

		public void delete(String id){


			//データベース接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DE_PASS)){


				//SQL分を準備
				String sql = "DELETE FROM MUTTER WHERE ID ="+ id + ";";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQLを実行
				pStmt.executeUpdate();

			}catch (SQLException e) {
				e.printStackTrace();
			}

			}

		}


