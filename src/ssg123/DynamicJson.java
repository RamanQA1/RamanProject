package ssg123;

import org.testng.annotations.Test;

import FILES.JAVA_PAYLOAD;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {

	@Test

	public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		String methodCall = JAVA_PAYLOAD.Addbook("Raman", "Smart boy");
		String response = given().log().all()
				.header("Content-Type", "application/json")
				.body(methodCall)
				.when()
				.post("Library/Addbook.php ")
				.then().log().all().assertThat().statusCode(200).extract()
				.response().asString();
		
		System.out.println("response body is: " + methodCall);

		JsonPath js1 = ReUsableMethods.getJsonResponse(response);
		String id = js1.get("ID");
		System.out.println(id);

	}

}
