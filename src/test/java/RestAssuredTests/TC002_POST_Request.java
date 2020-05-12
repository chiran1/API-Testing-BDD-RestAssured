package RestAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class TC002_POST_Request {
	public static HashMap map = new HashMap();

	@BeforeClass
	public void postData() {
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getFirstName());
		map.put("UserName", RestUtils.getFirstName());
		map.put("Password", RestUtils.getFirstName());
		map.put("Email", RestUtils.getFirstName());

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";
	}

	@Test
	public void testPost() {
		given().contentType("application/json").body(map)

				.when().post()

				.then().statusCode(201).and()
				// .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
				.and();
		// .body("Message", equalTo("Operation completed successfully"));

	}

}
