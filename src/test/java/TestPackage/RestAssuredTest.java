package TestPackage;

import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class RestAssuredTest {
	static String bodyPosts = "{\r\n"
			+ "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\r\n"
			+ "  \"title\": \"Generated schema for Root\",\r\n"
			+ "  \"type\": \"object\",\r\n"
			+ "  \"properties\": {\r\n"
			+ "    \"userId\": {\r\n"
			+ "      \"type\": \"number\"\r\n"
			+ "    },\r\n"
			+ "    \"id\": {\r\n"
			+ "      \"type\": \"number\"\r\n"
			+ "    },\r\n"
			+ "    \"title\": {\r\n"
			+ "      \"type\": \"string\"\r\n"
			+ "    },\r\n"
			+ "    \"body\": {\r\n"
			+ "      \"type\": \"string\"\r\n"
			+ "    }\r\n"
			+ "  },\r\n"
			+ "  \"required\": [\r\n"
			+ "    \"userId\",\r\n"
			+ "    \"id\",\r\n"
			+ "    \"title\",\r\n"
			+ "    \"body\"\r\n"
			+ "  ]\r\n"
			+ "}";
	
	public static void main(String[] args) {
		Response response = RestAssuredTest.getPostsApi();
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		long time = response.getTime();
		System.out.println("Time taken=" +time);
		Assert.assertTrue(response.getTime()<2000);
		
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(bodyPosts));
		
		// dealing with jsonPath()
		
		String userName = response.jsonPath().getString("user.name");
		List<String> roles = response.jsonPath().getList("user.roles");
		
		System.out.println("Username=" +userName);
		System.out.println("Roles=" +roles);
	}

	public static Response getPostsApi() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.header("Accept","application/json")
				.when().log().all()
				.get("/posts/1")
				.then().log().all()
				.extract()
				.response();
	}
	
	
	
	
}
