package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestExamples {
	
	@Test
	public void test_get() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200 );
	}
	
	
	
	@Test
	public void test_get_two() {
        baseURI = "https://reqres.in/api";
        Response response =
        given().
            get("/users?page=2").
        then().
            statusCode(200).
        extract().response();                                         //log().all(). for all log 
        int id = response.jsonPath().getInt("data.id[1]");            // Convert the Response to JsonPath
        Assert.assertEquals(8, id);                                   // Check using Assert
	}

}
