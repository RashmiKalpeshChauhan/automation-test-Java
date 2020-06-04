package com.qa.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.pojo.Booking;
import com.qa.pojo.BookingResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.BasePage;
import pages.BookingPage;


public class ApiTesting1 {
	InputStream inputStream;
	protected static Properties props;
	public static final String NEWLINE = System.getProperty("line.separator");
	protected BookingResponse bookingResponseJSon;
	@BeforeClass
	public void getResponse() throws Exception  {
		BasePage basePage=new BasePage();
		BookingPage bookingPage=new BookingPage(); 
		BookingResponse bookingResponseJSon;
		try {
			this.bookingResponseJSon = bookingPage.bookingReponse(Integer.parseInt(basePage.readPropertyData("roomsize")),"/request");
			//System.out.println("****  BookingResponse **** " + bookingResponseJSon);
		}  catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	@Test
	public void validatetype() throws IOException, URISyntaxException {					
		given().body(bookingResponseJSon).
		then().
		statusCode(200).
		body(bookingResponseJSon.getType(), equalTo("hotel")).		
		log().all();		
	}
	@Test
	public void validatedateinquery() throws IOException, URISyntaxException {		
		BasePage basePage=new BasePage();
		given().body(bookingResponseJSon).
		then().
		statusCode(200).
		body(bookingResponseJSon.getQuery(), hasItems(basePage.readPropertyData("checkin"), basePage.readPropertyData("chcekout"))).
		log().all();		
	}
	@Test
	public void validatedaPlaceId() throws IOException, URISyntaxException {		
		BasePage basePage=new BasePage();
		given().body(bookingResponseJSon).
		then().
		statusCode(200).
		body(bookingResponseJSon.getQueryParametersObj().getPlaceId(), not(null)).
		log().all();
	}
}
