package com.connection.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAOOperation implements Operations<Object,Object>{

	
	private Connection con;
	private Statement st;
	public DAOOperation()
	{		
		con = DBConnection.getConnection();
		try {
			 st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object update(Object value) {
		// TODO Auto-generated method stub
		try {
			int result = st.executeUpdate((String)value);
			System.out.println("Update result "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object insert(Object value) {
		// TODO Auto-generated method stub
		try {
			ResultSet result = st.executeQuery((String)value);
			System.out.println("Insert Request ");
			System.out.println(result.getMetaData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object delete(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object add(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findAll(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
