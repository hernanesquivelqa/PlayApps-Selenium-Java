package app;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.TestBase;
import pages.ApiRegresPage;
public class ApiTest extends TestBase{
	private ApiRegresPage page;
	@BeforeEach
	public void setupApi() {
		page = new ApiRegresPage(driver);
		   RestAssured.baseURI = page.getUrl();
	}

    @Test
    public void testGetUsers() {
        Response response = RestAssured
                .given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("Michael"));
    }

    @Test
    public void testSingleUser() {
    	
    	  Response response = RestAssured
    			  .given()
    			  .when()
    			  .get("/users/2");
    	  assertEquals(response.getStatusCode(),200);  	
    }
    @Test
    public void testSingleUserNotFound() {
        Response response = RestAssured
        		.given()
        		.when()
        		.get("/users/23"); 
        assertEquals(response.getStatusCode(), 404);
    }

    @Test 
    public void testListResource() {
    	Response response = RestAssured
    			.given()
    			.when()
    			.get("/unknown");
     JsonPath body = response.jsonPath();
     String page = body.getString("page");
     
     assertEquals(page, "1");
     assertEquals(response.getStatusCode(), 200);
    }
	@Test
	public void testCreateUser() {
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

	}

	@Test
	public void testUpdate() {
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
	public void testUpdatePatch() {
	    Response response = RestAssured
	        .given()
	            .header("Content-Type", "application/json")
	            .body("{\"name\": \"morpheus\",\"job\": \"zion resident\"}")
	            .when()
	            .patch("/users/2");
	    assertEquals(200, response.getStatusCode());
	    JsonPath json = response.jsonPath();
	    assertEquals("morpheus", json.getString("name"));
	    assertEquals("zion resident", json.getString("job"));
	    String updatedAt = json.getString("updatedAt");
	    assertNotNull(updatedAt);
	    assertFalse(updatedAt.isEmpty());	
	}
	
	@Test
	public void testDeleteUser() {
	    Response response = RestAssured
	        .given()
	        .when()
	        .delete("/users/2");
	    assertEquals(204, response.getStatusCode());
	    assertTrue(response.getBody().asString().isEmpty());
	}
	
}

//Response response = RestAssured
//.given()
//.header("Authorization", "Bearer token")
//.body("{ \"name\": \"Pablo\" }")
//.when()
//.post("/users");

//doc 
//https://reqres.in
//https://github.com/rest-assured/rest-assured/wiki/Usage