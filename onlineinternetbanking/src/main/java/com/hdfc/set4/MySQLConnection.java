package com.hdfc.set4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLConnection {

	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharyaDB", "root", "root");

			Statement stmt = con.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}