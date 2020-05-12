package RestAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*given()
	set cookies, add authorization, add parameters, set headers info etc
when()
	get, put, post, delete
then()
	validate status code, extract response, extract headers cookies and response body like:
	body("WeatherDescription", equalTo("haze"))
*/
public class TC001_GET_Request {

	@Test
	void getWeatherDetails() {

		given().when().get("http://restapi.demoqa.com/utilities/weather/city/Delhi").then()
				// .body("WeatherDescription", equalTo("haze"))
				.statusCode(200).statusLine("HTTP/1.1 200 OK").assertThat().header("Content-Type", "application/json");
	}

}
