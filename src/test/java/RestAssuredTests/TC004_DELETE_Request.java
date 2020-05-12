package RestAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class TC004_DELETE_Request {

	@Test
	public void deleteEmployeeRecord() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/23";

		Response response = // below statement will be stored in this response variable but need to add last
							// line of code.

				given()// if there is no prerequisite then can be deleted

						.when().delete().then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().all().extract()
						.response();

		String jsonAsString = response.asString();// convert the data in string
		Assert.assertEquals(jsonAsString.contains("successfully! deleted Recods"), false);
	}

}
