package com.test.vivek.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class config_reader {
	
	
	
	public static  String getProperty(String property) {
			
		Properties prop = new Properties();
		String value = null;
			try {
				File file = new File("config.properties");
				FileReader fr = new FileReader(file);

				prop.load(fr);
				value = prop.getProperty(property);
/*//				if (value.contains("_"))
//					value.replace("_", " ");
*/			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return value;
	}

	
}
