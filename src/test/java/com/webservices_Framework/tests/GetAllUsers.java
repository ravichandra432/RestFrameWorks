package com.webservices_Framework.tests;
/**
 * 
 * @author Shashikumara
 *
 */

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.web.generics.BaseLib;
import com.web.generics.IEndPoints;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GetAllUsers extends BaseLib {
	
	/**
	 * 
	 */
	@Test
	public void getAllUsers()
	{
		
		Response resp = given().get(IEndPoints.GET_ALL_USERS);
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void getSingleUser()
	{
		Response resp = given().pathParam("id", "1").when().get(IEndPoints.GET_SINGLE_USER);
		
		resp.then().log().all();	
	}
	
	@Test
	public void getUsersFirstName()
	{
		Response resp = given().get(IEndPoints.GET_ALL_USERS);
		List<Object> firstName = resp.jsonPath().get("data.first_name");
		
		for(Object obj:firstName)
		{
			Reporter.log(""+obj,true);
		
		}
		
		 ArrayList ls = new ArrayList();
		ls.add( "George");
		ls.add( "Janet");
		ls.add("Emma");
		ls.add("Eve");
		ls.add("Charles");
		ls.add("Tracey");
		
		Assert.assertEquals(ls, firstName);
		Reporter.log("user name is same",true);
		
	}
	
	@Test
	public void getUserMailId()
	{
		Object email = given().get(IEndPoints.GET_ALL_USERS).jsonPath().get("data[0].email");
		Reporter.log(""+email);
	}

}
