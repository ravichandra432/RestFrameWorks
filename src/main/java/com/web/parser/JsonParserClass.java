package com.web.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * 
 * @author Shashikumara
 *
 */
public class JsonParserClass {
	
	/**
	 * @param filename
	 * @throws FileNotFoundException 
	 * @throws JsonSyntaxException 
	 * @throws JsonIOException 
	 * @return
	 */

	public JSONObject convertToJsonObject(String filenmae) throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		Object obj = new JsonParser()
				.parse(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resource\\data"+filenmae));
	
		JSONObject jobj = (JSONObject)obj;
		return jobj;
	}
}

