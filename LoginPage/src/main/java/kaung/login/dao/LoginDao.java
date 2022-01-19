package kaung.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	static final String DB_URL = "jdbc:mysql://localhost/j2ee";
	
	static final String USER = "root";
	static final String PASS = "Kaung2000@";
	
	
	
	public boolean check(String name, String password) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "select* from user where name=? and password=?";
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, name);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if( rs.next() ) 
				return true;
			else 
				return false;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//finally block use to close resources
			try {
				if(stmt!=null) 
					stmt.close();
				} catch (SQLException se2 ) {
					//Nothing we can do
				}
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException se ) {
				se.printStackTrace();
			}
		}
		return false;
		
	}
}
