package com.hfdc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {

	private static Connection con = null;

	static {
		String url = "jdbc:postgresql://localhost:5432/forexMgn";
		String user = "postgres";
		String pass = "Postgre";
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
