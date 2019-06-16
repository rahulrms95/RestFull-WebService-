package com.rest.client;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.data.pojo.User;


public class RestClient {

	Client cl ;

	public RestClient()
	{
		cl = ClientBuilder.newClient();
	}

	public static void main(String[] args) {

		HttpAuthenticationFeature ff;
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target("http://127.0.0.1:8080/WebProject-0.0.1-SNAPSHOT/rest").path("/handler/getAllData");

		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response res = invocationBuilder.get();
		//String json ="{mean:20}";
		//Response response = invocationBuilder.post(Entity.entity(json, MediaType.APPLICATION_JSON));
		String resultString = res.readEntity(String.class);
		JSONArray jArray = null;
		try {
			jArray = new JSONArray(resultString);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = new ArrayList<>();
		for(int i=0;i<jArray.length();i++)
		{
			try {
				User user = mapper.readValue(jArray.getJSONObject(i).toString(), User.class);
				userList.add(user);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<userList.size();i++)
		{
			System.out.println(userList.get(i).getName());
		}
	}
}
