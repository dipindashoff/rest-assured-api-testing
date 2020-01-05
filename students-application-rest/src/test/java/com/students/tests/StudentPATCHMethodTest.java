package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//1. Add the static imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class StudentPATCHMethodTest extends TestBase {
	
	/*
	 * PATCH is for making just one change to the student
	 */

	// Modify 1 data of a student data using PATCH Method
	@Test
	public void patchStudentInfo() {

		// URI: {{url}}/student
		// Body in JSON
//		{
//	        "firstName": "Deesha",
//	        "lastName": "Dipin",
//	        "email": "monkey@monkey.com",
//	        "programme": "Pre-KG",			// Update from Circus to Pre-KG
//	        "courses": [
//	            "Nursery",
//				"Gymnastics"
//	        ]
//	    }

		// Create a Java Student object
		Student student = new Student();

		student.setFirstName("Deesha");
		student.setLastName("Sindiya");
		student.setEmail("monkey@monkey.com");
		student.setProgramme("Pre-KG"); // update
		student.setCourses(Arrays.asList("Nursery", "Gymnastics"));

		// STEP 3: PATCH

		// Set content-type as JSON in given()
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student) // pass the student object in body()
		.patch("/101")
		.then()
		.statusCode(200); 
	}
	
	@Test
	public void isNewSudentModifiedUsingGET() {
		
		// Print the complete student list
		when()
		.get("/101")
		.body()
		.prettyPrint();		
	}

}
