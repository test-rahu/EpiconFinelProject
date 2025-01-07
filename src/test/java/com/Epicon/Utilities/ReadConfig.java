package com.Epicon.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties propertis;
	String path="C:\\Users\\Rahul\\eclipse-workspace\\EpiconFinel\\Configuration\\config.properties";
	
	public ReadConfig() {
	
		try {
			propertis=new Properties();
			FileInputStream fis =new FileInputStream(path);
			propertis.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBaseURL() {
		String value=propertis.getProperty("baseurl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("URL not sepcified in config file");			
	}
	
	public String getBrowserL() {
		String browser=propertis.getProperty("browser");
		if(browser!=null)
			return browser;
		else
			throw new RuntimeException("browser not sepcified in config file");			
	}
	
	public String getUserName() {
		String usename=propertis.getProperty("username");
		if(usename!=null)
			return usename;
		else
			throw new RuntimeException("UserName not sepcified in config file");			
	}
	
	public String getPass() {
		String pass=propertis.getProperty("password");
		if(pass!=null)
			return pass;
		else
			throw new RuntimeException("pass not sepcified in config file");			
	}
}
