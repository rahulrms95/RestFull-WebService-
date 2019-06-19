package com.common.constant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBConfigurationFile {

	public final static String DB_URL;
	public final static String DB_USERNAME;
	public final static String DB_PASSWORD;
	
	
	
	static
	{
		//String dbConfigFile="/root/git/RestFull-WebService-/WebProject/src/main/resources/dbConfig.properties";
		String dbConfigFile="dbConfig.properties";
		
		Properties p = new Properties();
		try {
			p.load(new FileReader(dbConfigFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String DB_TYPE = p.getProperty("DB_type");
		String DB_NAME = p.getProperty("DB_Name");
		String DB_IP 	= p.getProperty("DB_ip");
		String DB_PORT = p.getProperty("DB_port");
		DB_USERNAME = p.getProperty("DB_Username");
		DB_PASSWORD = p.getProperty("DB_password");
		
		DB_URL = "jdbc:"+DB_TYPE+"://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
		System.out.println(DB_URL);
	}
	
	public static void main(String[] args) {
		
	}
	
}
