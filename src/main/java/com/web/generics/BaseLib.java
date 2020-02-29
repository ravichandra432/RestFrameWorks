package com.web.generics;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * 
 * @author Shashikumar
 *
 */
public class BaseLib {

	/**
	 * to initialize the base URI,port and authentication
	 * 
	 */
	
	
	
	@BeforeSuite
	public void config()
	{
		
		//baseURI="http://dummy.restapiexample.com/";
		//port=4444;
		//given().auth().basic(username,password);
		
		baseURI="https://reqres.in/";
		
		
	}
	
}
