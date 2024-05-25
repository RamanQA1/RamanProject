package ssg123;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import FILES.JAVA_PAYLOAD;
import io.restassured.path.json.JsonPath;

public class ValidationTestNG {
	
	@Test
	public void sumofcourses()
	{
		JsonPath js=new JsonPath(JAVA_PAYLOAD.CoursePrice());
		int count = js.getInt("courses.size()");
		
		int sum=0;
		for(int i1=0;i1<count;i1++)	
		{
			int copies=js.get("courses["+i1+"].copies");
			int price=js.get("courses["+i1+"].price");
			int amount =  copies*price;
			System.out.println(amount);
			sum=sum+amount;
		}
		System.out.println("Total sum of the copies");
		System.out.println(sum);
		
//		assertEquals(sum, 910); 
		
		int Purchaseamount= js.getInt("dashboard.purchaseAmount");
		assertEquals(sum,Purchaseamount);

		
	}

}
