import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * データベースにテーブルを作成するクラス。
 */
public class Initialize {
	static final String CREATE_TABLE_SEGAAT =
			"CREATE TABLE IF NOT EXISTS SEGAAT (" +
					" ID    SERIAL,"+
					" COMMENT      VARCHAR," +
					" DATE    VARCHAR," +
					" AUTHER     VARCHAR);";
	static final String INSERT_SEGAAT =
			"INSERT INTO SEGAAT (COMMENT, DATE, AUTHER) VALUES (?, ?, ?)";
	static final String DELETE_SEGAAT =
			"DELETE FROM SEGAAT";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");

			try (	Connection con = DriverManager.getConnection("jdbc:postgresql:SEGATTER", "postgres", "password");
					PreparedStatement pstmt = con.prepareStatement(CREATE_TABLE_SEGAAT);
					){
				// テーブル作成
				pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Class.forName("org.postgresql.Driver");

			try (	Connection con = DriverManager.getConnection("jdbc:postgresql:SEGATTER", "postgres", "password");
					PreparedStatement pstmt1 = con.prepareStatement(DELETE_SEGAAT);
					PreparedStatement pstmt2 = con.prepareStatement(INSERT_SEGAAT);
					){
				// レコード削除
				pstmt1.executeUpdate();

				// レコード登録（1件目）
				pstmt2.setString(1, "testComment");
				pstmt2.setString(2,"2016-05-17");
				pstmt2.setString(3, "sega");
				pstmt2.executeUpdate();

				// レコード登録（2件目）
				pstmt2.setString(1, "Hello, World!");
				pstmt2.setString(2, "2016-05-18");
				pstmt2.setString(3, "taro");
				pstmt2.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("SUCCESS");

	}
}

