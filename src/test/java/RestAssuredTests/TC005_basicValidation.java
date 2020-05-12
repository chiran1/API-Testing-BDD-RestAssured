package RestAssuredTests;

//test status code
//log response
//verifying single content in response body
//verifying multiple contents in response body
//setting parameters and headers
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;

public class TC005_basicValidation {

// test status code

	// @Test(priority = 1)
	public void testStatusCode() {
		// given()//we can remove given here and start with when

		when().get("http://jsonplaceholder.typicode.com/todos/3").then().statusCode(200);
		// .log().all();//for detail response
	}

	// @Test(priority = 2)
	public void testLogging() {
		given()

				.when().get("http://restcountries.eu/rest/v2/name/nepal")

				.then().statusCode(200);
		// .log().all();

	}

	// verifying single content in response body

	// @Test(priority = 3)
	public void testSingleContent() {
		given()

				.when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat()
				.body("MRData.total", equalTo("20"));
		// .body("")
		// .log().all();
		// .assertThat()

	}

	// verifying single content in response body

	// @Test(priority = 4)
	public void testMultipleContents() {
		given()

				.when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasItems("albert_park", "americas"));
		// .body("")
		// .log().all();
		// .assertThat()

	}

	// setting parameters and headers
	@Test(priority = 5)
	public void testParamsAndHeaders() {
		given().params("MyName", "chiran").header("MyHeader", "Indian")

				.when().get("http://restcountries.eu/rest/v2/name/nepal")

				.then().statusCode(200).log().all();

	}
}