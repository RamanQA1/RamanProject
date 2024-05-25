package ssg123;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import FILES.JAVA_PAYLOAD;
public class BASIC_CLASS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		VALIDATE IF ADD PLACE API IS WORKING OR NOT
		 
//		ADD PLACE > UPDATE PLACE WITH NEW ADDRESS >  GET PLACE TO VALIDATE NEW ADDRESS IS PRESENT IN RESPONSE

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(JAVA_PAYLOAD.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo ("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.print(response);

		JsonPath js=new  JsonPath(response);
	String PlaceID =	js.getString("place_id");
	System.out.print(PlaceID);


//	UPDATE PLACE IN RECENT PLACE ID.
	
	String NewAddress = "70 Summer walk, USA";
	given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\r\n"
			+ "\"place_id\":\""+PlaceID+"\",\r\n"
			+ "\"address\":\""+NewAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
	
		+ "").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo ("Address successfully updated"));
	
	
//	GET PLACE TO CHECK DATA UPDATED OR NOT.
	
//	[SIMPLE METHODE FOR GET DATA IN RECENT PLACE ID.]
	
//	given().log().all().queryParam("key","qaclick123").queryParam("place_id",PlaceID)
//	.when().get("maps/api/place/get/json").then().log().all()
//    .assertThat().statusCode(200).body("address", equalTo ("70 Summer walk, USA"));
	
	
//	[USING VARIAVLE METHODE FOR GETTING DATA ] METHOD 2  (VARIABLE NAME = NewAddress we set in update palce).
	
	
	String GetPlaceresponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",PlaceID)
	.when().get("maps/api/place/get/json").then().log().all()
    .assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js1 = ReUsableMethods.getJsonResponse(GetPlaceresponse);
	String ActualAddress= js1.getString("address");
	System.out.println(ActualAddress);
	Assert.assertEquals(ActualAddress,NewAddress);
	
		
	}

}
