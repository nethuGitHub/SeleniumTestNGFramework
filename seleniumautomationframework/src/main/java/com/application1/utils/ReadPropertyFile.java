package com.application1.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.application1.Enums.ConfigEnum;
import com.application1.constants.FrameworkConstants;

public class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();

	static {
		try{
			System.out.println(FrameworkConstants.getConfigPath());
			FileInputStream filevar = new FileInputStream(FrameworkConstants.getConfigPath());
			property.load(filevar);

			for (Map.Entry<Object,Object> key : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(key.getKey()), String.valueOf(key.getValue()));

			}
			//property.entrySet().forEach(key -> CONFIGMAP.put(String.valueOf(key.getKey()), String.valueOf(key.getValue())));
		}
		catch (IOException e){
			e.printStackTrace();
		}

	}

	public static String get(ConfigEnum key) throws IOException {

		return CONFIGMAP.get(key.name().toLowerCase());


	}

	
}
