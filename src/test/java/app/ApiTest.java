package app;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ApiTest {
	@Disabled("Este test está desactivado temporalmente")
    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://reqres.in/api";
        Response response = RestAssured
                .given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("Michael"));
    }
	@Disabled("Este test está desactivado temporalmente")
    @Test
    public void testSingleUser() {
    	RestAssured.baseURI = "https://reqres.in/api";
    	
    	  Response response = RestAssured
    			  .given()
    			  .when()
    			  .get("/users/2");
    	// System.out.println(response.getBody().asPrettyString());
   
    	  assertEquals(response.getStatusCode(),200);
    	
    }
	@Disabled("Este test está desactivado temporalmente")
    @Test
    public void testSingleUserNotFound() {
    	RestAssured.baseURI = "https://reqres.in/api";
        Response response = RestAssured
        		.given()
        		.when()
        		.get("/users/23");
        
        assertEquals(response.getStatusCode(), 404);
    }
	@Disabled("Este test está desactivado temporalmente")
    @Test 
    public void testListResource() {
    	RestAssured.baseURI = "https://reqres.in/api";
    	Response response = RestAssured
    			.given()
    			.when()
    			.get("/unknown");
     JsonPath body = response.jsonPath();
     String page = body.getString("page");
     System.out.println(page);
     
     assertEquals(page, "1");
     assertEquals(response.getStatusCode(), 200);
    }

	@Test
	public void testCreateUser() {
	    RestAssured.baseURI = "https://reqres.in/api";
	    Response response = RestAssured
	        .given()
	            .header("Content-Type", "application/json")
	            .body("{\"name\": \"morpheus\",\"job\": \"leader\"}")
	        .when()
	            .post("/users");
	    assertEquals(201, response.getStatusCode());
	    JsonPath json = response.jsonPath();
	    assertEquals("morpheus", json.getString("name"));
	    assertEquals("leader", json.getString("job"));
	    System.out.println("ID: " + json.getString("id"));
	    System.out.println("Fecha de creación: " + json.getString("createdAt"));
	}
	@Test
	public void testUpdate() {
	    RestAssured.baseURI = "https://reqres.in/api";
	    Response response = RestAssured
	        .given()
	            .header("Content-Type", "application/json")
	            .body("{\"name\": \"morpheus\",\"job\": \"zion resident\"}")
	            .when()
	            .put("/users/2");
	    assertEquals(200, response.getStatusCode());
	    JsonPath json = response.jsonPath();
	    assertEquals("morpheus", json.getString("name"));
	    assertEquals("zion resident", json.getString("job"));
	    String updatedAt = json.getString("updatedAt");
	    assertNotNull(updatedAt);
	    assertFalse(updatedAt.isEmpty());

		
	}
	
}
//Response response = RestAssured
//.given()
//.header("Authorization", "Bearer token")
//.body("{ \"name\": \"Pablo\" }")
//.when()
//.post("/users");

//doc https://reqres.in
//https://github.com/rest-assured/rest-assured/wiki/Usage