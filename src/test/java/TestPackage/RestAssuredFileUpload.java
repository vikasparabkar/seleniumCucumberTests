package TestPackage;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredFileUpload {

	public static void main(String[] args) {
		Response response  = uploadDocument();
		
		Assert.assertEquals(response.getStatusCode(), 201);

		String fileName = response.jsonPath().getString("originalname");
		Assert.assertEquals(fileName, "test.pdf");
		System.out.println("Document is uploaded successfully.");
	}

	public static Response uploadDocument() {
		RestAssured.baseURI = "https://api.escuelajs.co/api/v1/files";
		
		return RestAssured
				.given()
				.header("Accept","application/json")
				.multiPart("file", new File("src/test/java/utils/test.pdf"))
				.when().log().all()
				.post("/upload")
				.then().log().all()
				.extract().response();
		
	}
	
}
