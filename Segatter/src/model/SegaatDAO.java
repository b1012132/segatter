package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SegaatDAO {

	private final String DRIVER_NAME = "org.postgresql.Driver";
	private final String JDBC_URL =
			"jdbc:postgresql:DB_JAVA_SERVERSIDE";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

	public ArrayList<Segaat> findAll(){
		Connection con = null;
		ArrayList<Segaat> segaatList = new ArrayList<Segaat>();

		try{
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS);

			// SELECT文の準備
			String sql =
					"SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("ID");
				String comment = rs.getString("COMMENT");
				String date = rs.getString("DATE");
				String auther = rs.getString("AUTHER");
				Segaat segaat = new Segaat(comment, date, auther);
				segaatList.add(segaat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return segaatList;
	}
}
