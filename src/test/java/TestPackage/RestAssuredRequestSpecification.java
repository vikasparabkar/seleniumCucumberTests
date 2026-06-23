package TestPackage;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredRequestSpecification {

	public static void main(String[] args) {
		// Define Request Specification
        RequestSpecification requestSpec = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType("application/json");

        // Define Response Specification
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("userId", equalTo(1))
                .build();

        // Use both specifications in a test
        Response response = given()
                .spec(requestSpec)          // apply request setup
                .when()
                .get("/posts/1");

        response.then()
                .spec(responseSpec);        // apply response validations


	}

}
