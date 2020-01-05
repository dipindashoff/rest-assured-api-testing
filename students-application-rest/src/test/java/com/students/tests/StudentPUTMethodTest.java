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

public class StudentPUTMethodTest extends TestBase {

	// Update details of a student data using PUT Method
	@Test
	public void updateNewStudent() {

		// URI: {{url}}/student/101
		// Body in JSON
//		{
//			"id": 101,
//	        "firstName": "Deesha",
//	        "lastName": "Dipin",
//	        "email": "cutiepie@peaches.com", // update
//	        "programme": "School",
//	        "courses": [
//	            "Playing",
//				"Eating Fruits", // update
//				"Ladder Climbing" // update
//	        ]
//	    }

		// Create a Java Student object
		Student student = new Student();

		student.setFirstName("Deesha");
		student.setLastName("Dipin");
		student.setEmail("cutiepie@peaches.com");
		student.setProgramme("School");
		student.setCourses(Arrays.asList("Playing", "Eating Fruits", "Ladder Climbing"));

		// STEP 3: POST

		// Set content-type as JSON in given()
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student) 
		.put("/101") // enter the 'id' here
		.then()
		.statusCode(200); // success status is 200
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
