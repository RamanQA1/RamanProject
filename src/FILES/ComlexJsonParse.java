package FILES;

import io.restassured.path.json.JsonPath;



public class ComlexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JsonPath js=new JsonPath(JAVA_PAYLOAD.CoursePrice());
		
		
//		[Print no of course return by API]
		
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
//		[Print Purchase Ampont]
		
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		
//		[Print Title of the first course]
		
		String TitleFirstCourse = js.getString("courses[0].title");
		System.out.println(TitleFirstCourse);
		
		
//		[Print all courses title and their respective prices]
		
		for(int i=0;i<count;i++)
		{
		
		String CourseTitle =js.getString("courses["+i+"].title"); 
		System.out.println(CourseTitle);
		
//		int allAmount=js.getInt("courses["+i+"].price");
//		System.out.println(allAmount);
		
		System.out.println( js.get("courses["+i+"].price").toString());
		}
		
//		[Print no of copies sold by RPA]
		
//	    System.out.println( js.get("courses[2].copies").toString());

//		int RPAtotal= js.get("courses[2].copies");		
//		System.out.println(RPAtotal);
		
		System.out.println("Print no of copies sold by RPA");
		
		
			for(int i=0;i<count;i++)
			{
			
			String CourseTitle =js.getString("courses["+i+"].title"); 
			if(CourseTitle.equalsIgnoreCase("RPA"))
			{ 	
				int copies=js.get("courses["+i+"].copies");
				System.out.println(copies);
			}
			
			}
//			[Print sum of courses]
			
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

			

	}
			
		}

	
