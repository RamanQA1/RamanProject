package ssg123;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	
	public static JsonPath getJsonResponse(String GetPlaceresponse) {
	JsonPath js1 =new  JsonPath(GetPlaceresponse);
	return js1;
	}

}
