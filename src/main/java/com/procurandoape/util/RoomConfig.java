package com.procurandoape.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RoomConfig {

	public static String getProperty(String key) {
		Properties properties = new Properties();
		try {
			InputStream stream = RoomConfig.class.getClassLoader().getResourceAsStream("config.properties");
			properties.load(stream);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not fou when retrieved the property: " + key, e);
		} catch (IOException e) {
			throw new RuntimeException("Error while retrieve the property: " + key, e);
		}
		return properties.getProperty(key);
	}

}
