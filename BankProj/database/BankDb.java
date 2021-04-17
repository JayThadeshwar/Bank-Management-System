package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankDb {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank","root", "");
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
		
		return conn;
	}
}
