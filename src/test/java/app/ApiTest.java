package app;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://reqres.in/api";


        Response response = RestAssured
                .given()
                .queryParam("page", 2)
                .when()
                .get("/users");

     
        System.out.println(response.getBody().asPrettyString());

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("Michael"));
    }
}


//Response response = RestAssured
//.given()
//.header("Authorization", "Bearer token")
//.body("{ \"name\": \"Pablo\" }")
//.when()
//.post("/users");
