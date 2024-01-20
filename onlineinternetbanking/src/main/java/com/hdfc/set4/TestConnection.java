package com.hdfc.set4;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		Connection con = MySQLConnection.getConnection();

		System.out.println(con+" Connected");
	}

}
