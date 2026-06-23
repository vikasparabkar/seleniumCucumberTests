package TestPackage;

import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class testtGetRequestRestAssured {
	
	static String getBody = "{\r\n"
			+ "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\r\n"
			+ "  \"title\": \"Generated schema for Root\",\r\n"
			+ "  \"type\": \"array\",\r\n"
			+ "  \"items\": {\r\n"
			+ "    \"type\": \"object\",\r\n"
			+ "    \"properties\": {\r\n"
			+ "      \"userId\": {\r\n"
			+ "        \"type\": \"number\"\r\n"
			+ "      },\r\n"
			+ "      \"id\": {\r\n"
			+ "        \"type\": \"number\"\r\n"
			+ "      },\r\n"
			+ "      \"title\": {\r\n"
			+ "        \"type\": \"string\"\r\n"
			+ "      },\r\n"
			+ "      \"body\": {\r\n"
			+ "        \"type\": \"string\"\r\n"
			+ "      }\r\n"
			+ "    },\r\n"
			+ "    \"required\": [\r\n"
			+ "      \"userId\",\r\n"
			+ "      \"id\",\r\n"
			+ "      \"title\",\r\n"
			+ "      \"body\"\r\n"
			+ "    ]\r\n"
			+ "  }\r\n"
			+ "}";

	public static void main(String[] args) {
		Response response = testtGetRequestRestAssured.getAPI();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code is verified");
		
		long time = response.getTime();
		Assert.assertTrue(time<3000);
		System.out.println("Time taked is less than 3000ms");
		
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getBody));
		System.out.println("Json schema is validated.");
		
		String firstIdTitle = response.jsonPath().getString("[0].title");
		Assert.assertEquals(firstIdTitle, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		System.out.println("First id title is verified.");
		
		List<String> titles = response.jsonPath().getList("title");
		assert titles.contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"):"Title not found";
		System.out.println("Required title is available in the list.");
	}
	
	public static Response getAPI() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.header("Accept","application-json")
				.when().log().all()
				.get()
				.then().log().all()
				.extract().response();
				
	}

	
	
}
