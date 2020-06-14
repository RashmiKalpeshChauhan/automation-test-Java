package com.qa.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pojo.BookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.BasePage;
import pages.BookingPage;


public class ApiTesting1 {
	InputStream inputStream;
	protected static Properties props;
	public static final String NEWLINE = System.getProperty("line.separator");
	protected BookingResponse bookingResponseJSon;

	@Test(description = "Validate checkin and checkout")	
	public void validatechcekinchcekout() throws IOException {
		BookingPage bookingPage=new BookingPage();
		BasePage basePage=new BasePage();		
		baseURI=basePage.readPropertyData("url");
		Response response = given().
				contentType(ContentType.JSON).
				body(bookingPage.bookingReponse1(1)).
				post("/request").
				then().
				statusCode(200).
				extract().response()				;
		Assert.assertTrue(response.jsonPath().getString("query").contains(basePage.readPropertyData("checkin")));
		Assert.assertTrue( response.jsonPath().getString("query").contains(basePage.readPropertyData("chcekout")));
	}
	@Test(description = "Validate query param object")	
	public void validateQueryparamobj() throws IOException {
		BookingPage bookingPage=new BookingPage();
		BasePage basePage=new BasePage();		
		baseURI=basePage.readPropertyData("url");
		given().
		contentType(ContentType.JSON).
		body(bookingPage.bookingReponse1(1)).
		post("/request").
		then().	
		statusCode(200).
		body("type", equalTo("hotel")).
		body("queryParametersObj.sortBy",equalTo("distanceScore")).
		body("queryParametersObj.isGeo",equalTo(1)).		
		body("queryParametersObj.isCountry",equalTo("false"));
	}
	@Test(description = "Validate place id is not null")	
	public void validateplaceId() throws IOException {
		BookingPage bookingPage=new BookingPage();
		BasePage basePage=new BasePage();		
		baseURI=basePage.readPropertyData("url");
		Response response = given().
				contentType(ContentType.JSON).
				body(bookingPage.bookingReponse1(1)).
				post("/request").
				then().
				statusCode(200).
				extract().response();
		Assert.assertTrue(!response.jsonPath().getString("queryParametersObj.placeId").equals(null));		  
	}
}
