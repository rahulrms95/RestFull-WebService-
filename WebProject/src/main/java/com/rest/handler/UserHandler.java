package com.rest.handler;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.connection.database.DBOperation;
import com.user.data.pojo.User;

@Path("/handler")
public class UserHandler {

	DBOperation op;
	public UserHandler() {
		// TODO Auto-generated constructor stub
		op = new DBOperation();
	}
	@GET
	@Path("/getAllData")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllData()
	{
		return op.findAllData(null);
	}
	
	@GET
	@Path("/getData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User getData(User user)
	{
		return op.find(user);
	}
	
}
