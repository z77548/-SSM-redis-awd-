package com.ssm.chapter.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private String dburl = "jdbc:mysql://localhost:3306/awd?useUnicode=true&characterEncoding=GBK";
	private String dbuser = "";
	private String dbpass = "";
	public Connection Connection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (SQLException e) {
			System.out.println("no coon");
		}
		System.out.printf("conet scss");

		return conn;
	}

	public static void main(String[] args) {
		DatabaseConnection DatabaseConnection = new DatabaseConnection();
		Connection conn = 	DatabaseConnection.Connection();
		
	}

}
