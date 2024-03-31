package miniCasino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public DBConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaclass1";
			String id = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url,id,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void connClose() {
		if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
	public void pstmtClose() {
		if(pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
	}
	public void rsClose() {
		if(rs != null) try {rs.close(); pstmt.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
}
