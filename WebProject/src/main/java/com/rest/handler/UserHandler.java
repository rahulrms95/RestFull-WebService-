package com.rest.handler;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	@DELETE	
	@Path("/deleteData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User deleteData(User user)
	{
		return op.delete(user);
	}
	
	@POST
	@Path("/addData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User postData(User user)
	{
		return op.add(user);
	}
	
	@PUT
	@Path("/updateData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateData(User user)
	{
		return op.update(user);
	}
	public static void main(String[] args) {
		
		User us = new User();
		us.setUserid("562");
		us.setAge(20);
		us.setName("ram");
		//new UserHandler().deleteData(us);
		new UserHandler().postData(us);
		//new UserHandler().updateData(us);
		
	}
}
