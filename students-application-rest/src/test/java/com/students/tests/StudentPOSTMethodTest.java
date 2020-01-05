package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//1. Add the 2 static imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class StudentPOSTMethodTest extends TestBase {

	/*
	 * http://localhost:8085/student Base URI = http://localhost Port = 8085 Base
	 * Path = /student
	 */

	/*
	 * Given -> Set cookies, add auth, add params, set header info When -> GET,
	 * POST, PUT, DELETE, etc THEN -> Validate status code, extract response,
	 * response-body, headers, cookies
	 */

	// 3. Add new student data using POST Method
	@Test
	public void createNewStudent() {

		// URI: {{url}}/student
		// Body in JSON
//		{
//	        "firstName": "Deesha",
//	        "lastName": "Dipin",
//	        "email": "monkey@monkey.com",
//	        "programme": "Circus",
//	        "courses": [
//	            "Nursery",
//				"Gymnastics"
//	        ]
//	    }

		// STEP 1: Create a Java Student object & send it as the body (in jSON) to the
		// POST method

		/*
		 * To post a body in JSON: REST Assured supports mapping Java objects to and
		 * from JSON. For JSON you need to have either Jackson, Jackson2, Gson or
		 * Johnzon in the classpath. Courtesy:
		 * https://github.com/rest-assured/rest-assured/wiki/Usage
		 */

		// Step 1.1: Create a Student class in src/main/java
		// Each data type in the JSON body will be a variable. E.g. Student class should
		// have a variable as firstName. Make all variables private & create getters &
		// setters for every variable.
		// STEP 2: Add the Jackson Databind dependency

		// Create a Java Student object
		Student student = new Student();

		student.setFirstName("Deesha");
		student.setLastName("Dipin");
		student.setEmail("monkey@monkey.com");
		student.setProgramme("Circus");
		student.setCourses(Arrays.asList("Nursery", "Gymnastics"));

		// STEP 3: POST

		// Set content-type as JSON in given()
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student) // pass the student object in body()
		.post()
		.then()
		.statusCode(201); // For a POST method, the success status is 201 created
	}
	
	@Test
	public void isNewSudentAddedUsingGET() {
		
		// Print the complete student list
		when()
		.get("/101")
		.body()
		.prettyPrint();		
	}

}
