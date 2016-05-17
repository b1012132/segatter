package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModel {

	public static void main(String[] args){
		Connection con = null;

		try{
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:h2:file:C:/Workspace_for_Java_Serverside/Segatter","postgresql","password");

			String sql = "SELECT * FROM SEGAAT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				String id = rs.getString("id");
				String text = rs.getString("text");
				String auther = rs.getString("auther");
				String date = rs.getString("date");

				System.out.println("id :"+id);
				System.out.println("text : "+text);
				System.out.println("name :"+auther);
				System.out.println("date :"+date+"\n");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}
