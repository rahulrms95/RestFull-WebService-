package com.connection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.common.constant.DBConfigurationFile;

public class DBConnection {

	/**
	 * Read Database configuration from file 
	 * */
	static String  url = DBConfigurationFile.DB_URL;
	static String user = DBConfigurationFile.DB_USERNAME;
	static String password = DBConfigurationFile.DB_PASSWORD;
	private static Connection con = null;
	public static Connection getConnection()
	{
		if(con == null)
		{
			synchronized (DBConnection.class) {
				if(con == null)
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection(url,user,password);
						//Statement stm = con.createStatement();
						//stm.execute("create table users (name varchar(50),age int, userid varchar(50) primary key);");
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return con;
	}

	public static void main(String[] args) {

		getConnection();
	}
}
