package com.hdfc.poc.filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {

	private static Connection con = null;

	static {
		String url = "jdbc:postgresql://localhost:5432/ForexMgn";
		String user = "postgres";
		String pass = "B@ngalore198811";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

}
