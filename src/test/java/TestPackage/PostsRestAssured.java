package TestPackage;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PostsRestAssured {
	
	static String postSchema = "{\r\n"
			+ "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\r\n"
			+ "  \"title\": \"Post schema\",\r\n"
			+ "  \"type\": \"object\",\r\n"
			+ "  \"properties\": {\r\n"
			+ "    \"id\": { \"type\": \"number\" }\r\n"
			+ "  },\r\n"
			+ "  \"required\": [\"id\"]\r\n"
			+ "}\r\n"
			+ "";

	public static void main(String[] args) {
		Response response = postsRequest();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertTrue(response.getTime()<3000);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(postSchema));

	}
	
	public static Response postsRequest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		String requestBody = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"title\": \"My new post\",\n" +
                "  \"body\": \"This is the content of the post\"\n" +
                "}";
		
		return RestAssured
				.given()
				.header("Accept","application/json")
				.body(requestBody)
				.when().log().all()
				.post("/posts")
				.then().log().all()
				.extract().response();
				
	}

}
