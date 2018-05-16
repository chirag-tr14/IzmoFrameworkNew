package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static Connection conn;

	private static Statement getStatements() throws SQLException, ClassNotFoundException {
		if (conn == null || conn.isClosed()) {
			// For credentials
			Class.forName("com.mysql.jdbc.Driver");
			String userName = "rajesh.n";
			String passWord = "ra&95$sHe2N5";
			// connection driver
			conn = DriverManager.getConnection("jdbc:mysql://idbw:3306/izmoweb_r1v2", userName, passWord);
		}
		return conn.createStatement();
	}

	public static ResultSet getData(String query) throws SQLException, ClassNotFoundException {
		ResultSet data = getStatements().executeQuery(query);
		return data;
	}

	public void closeConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
// db.url=jdbc:mysql://idbw/izmoweb_r1v2?useOldAliasMetadataBehavior=true&characterEncoding=utf8