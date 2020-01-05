package com.student.loggingValues;

//1. Add the 3 static imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;

/*
 * Logs are written under the given() method
 */

public class LoggingRequestValues extends TestBase {
	
	/*
	 * Print request headers
	 */
	@Test
	public void printRequestHeader() {
		
		System.out.println("----Print only the Headers----");
		
		// GET student of id=1
		given()
		.log()
		.headers() // Logs only the headers
		.when()
		.get("/1")
		.then()
		.statusCode(200);			
	}
	
	/*
	 * Print request Params
	 */
	@Test
	public void printRequestParams() {
		
		System.out.println("----Print only the Params----");
		
		// GET student of programme="Financial Analysis" & limit search to '1'
		given()
		.param("programme", "Financial Analysis")
		.param("limit", "1")
		.log()
		.params() // Logs only the parameters
		.when()
		.get("/1")
		.then()
		.statusCode(200);			
	}
	
	/*
	 * Print request Body
	 */
	@Test
	public void printRequestBody() {
		
		System.out.println("----Print only the Body----");
		
		Student student = new Student();

		student.setFirstName("Deesha");
		student.setLastName("Dipin");
		student.setEmail("test@test.com");
		student.setProgramme("School");
		student.setCourses(Arrays.asList("Rhymes", "Dance"));
	
		given()
		.contentType(ContentType.JSON)
		.log()
		.body() // Logs only the content of the body. The body will be pretty-printed by default
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201); 			
	}
	
	/*
	 * Print all e.g. headers, cookies, body
	 */
	@Test
	public void printRequestAll() {
		
		System.out.println("----Print All----");
		
		Student student = new Student();

		student.setFirstName("Sindiya");
		student.setLastName("Dipin");
		student.setEmail("sin@seraph.com");
		student.setProgramme("Work");
		student.setCourses(Arrays.asList("Testing"));
	
		given()
		.contentType(ContentType.JSON)
		.log()
		.all() // Logs everything in the specification, including e.g. headers, cookies, body
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201); 			
	}
	
	/*
	 * Print all only if it fails!
	 * FAIL Scenario -> should print all
	 */
	@Test
	public void printRequestAllIfFail1() {
		
		System.out.println("----Print All if validation fails----");
		System.out.println("FAIL Scenario -> should print all");
		
		/*
		 * If I try to add the same student info again, it'll fail with status code = 500
		 * To make this validation fail, I'll just add the same details again
		 * Because validation fails, it should print all.
		 */
		
		Student student = new Student();

		student.setFirstName("Sindiya");
		student.setLastName("Dipin");
		student.setEmail("sin@seraph.com");
		student.setProgramme("Work");
		student.setCourses(Arrays.asList("Testing"));
	
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails() // Logs everything if a test validation fails
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201); 	// status code 500 is returned -> prints all log		
	}
	
	/*
	 * Print all only if it fails!
	 * PASS Scenario -> should not print anything as the validation passes
	 */
	@Test
	public void printRequestAllIfFail2() {
		
		System.out.println("----Print All if validation fails----");
		System.out.println("PASS Scenario -> should not print anything");
		
		/*
		 * If I try to add the same student info again, it'll fail with status code = 500
		 * To make this validation fail, I'll just add the same details again
		 * Because validation fails, it should print all.
		 */
		
		Student student = new Student();

		student.setFirstName("Dinesh");
		student.setLastName("Cheruvu");
		student.setEmail("dineshcheruvu@gmail.com");
		student.setProgramme("Work");
		student.setCourses(Arrays.asList("Automation Testing"));
	
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails() // Logs everything if a test validation fails
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201); 		// does not print any log	
	}

}
