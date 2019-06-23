package com.qa.httpprest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties properties;

	public TestBase() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(
					"C:\\Users\\Mutturaj\\workspace\\com.qa.httpprest\\src\\main\\java\\com\\qa\\httpprest\\config\\config.proprties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public String getValue(String str){
		return properties.getProperty(str);
	}

}
