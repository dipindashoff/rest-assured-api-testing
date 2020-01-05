package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//1. Add the 3 static imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class StudentGETMethodTest extends TestBase{

	/*
	 * http://localhost:8085/student/list 
	 * Base URI = http://localhost 
	 * Port = 8085
	 * Base Path = /student
	 */
	
	/*
	 * Given -> Set cookies, add auth, add params, set header info
	 * When -> GET, POST, PUT, DELETE, etc
	 * THEN -> Validate status code, extract response, response-body, headers, cookies
	 */

	// 2. Set init() method -- this method is written inside TestBase.java
	// This code is redundant; included here just for reference.
	@BeforeClass
	public static void init() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
	
	@Test
	public void getAllStudentList() {
		
				when()
				.get("/list")
				.body()
				.prettyPrint();		
	}
}
