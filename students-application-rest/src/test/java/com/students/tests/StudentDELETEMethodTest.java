package com.students.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;

public class StudentDELETEMethodTest extends TestBase{

	@Test
	public void deleteStudentRecord() {
		
		when()
		.delete("/101")
		.then()
		.statusCode(204); // status code is 204 for delete()
	}

}
