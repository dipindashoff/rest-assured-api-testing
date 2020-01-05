package com.student.base;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	// Set init() method
	@BeforeClass
	public static void init() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
}
