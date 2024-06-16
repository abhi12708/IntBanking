package com.initbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	//Create a constructor to load file
	public ReadConfig() 
	{
		File src =new File("./Configurations\\config.properties");
		
		try {
			FileInputStream fis= new FileInputStream (src);
			pro =new Properties();
			pro.load(fis); //load is a method to load complete File at run file.
		} 
		catch(Exception e)
		{
			System.out.println("Expception is"+e.getMessage());
		
		}	
	}
	//craete a Different Method for every object to read 
	public String getApplicationURL()
	{
		String url= pro.getProperty("baseURL");
		return url;
	}
	//User Name:
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}
	//Password
	public String getPassword()
	{
		String password= pro.getProperty("password");
		return password;
	}
	//Chrome Path
	public String getChromePath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	//Edge Browser Path
	public String getEdgePath()
	{
		String edgepath= pro.getProperty("edgepath");
		return edgepath;
	}
	
}
