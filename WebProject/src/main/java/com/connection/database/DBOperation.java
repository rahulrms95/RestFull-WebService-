package com.connection.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.user.data.pojo.User;

public class DBOperation implements Operations<User,User>{

	private Connection con ;
	
	public DBOperation()
	{
		con = DBConnection.getConnection();
	}

	@Override
	public User update(User value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User value) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<User> findAllData(String value) {
		// TODO Auto-generated method stub
		List<User> resultlst = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from users");
			while(result.next())
			{
				User row = new User();
				row.setName(result.getString("name"));
				row.setAge(result.getInt("age"));
				row.setUserid(result.getString("userid"));
				resultlst.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultlst;
	}
	
	@Override
	public User find(User value) {
		// TODO Auto-generated method stub
		User row = null ;
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet result = st.executeQuery("select * from users where userid='"+value+"'");
			while(result.next())
			{
				row = new User();
				row.setName(result.getString("name"));
				row.setAge(result.getInt("age"));
				row.setUserid(result.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return row;
	}

	@Override
	public List<User> findAll(User value) {
		// TODO Auto-generated method stub
		List<User> resultlst = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from users");
			while(result.next())
			{
				User row = new User();
				row.setName(result.getString("name"));
				row.setAge(result.getInt("age"));
				row.setUserid(result.getString("userid"));
				resultlst.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultlst;
	}
	
}
