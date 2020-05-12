package RestAssuredTests;

import org.testng.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*1) verify single content in XML response
2) verify multiple contents in XML response
3) verify all the content in XML response in one go
4) find values using XML path in XML response
5) XPath with Text() function
*/
public class TC006_basicValidation_XML {
//verifying single content

	// @Test(priority=1)
	void testSingleContent() {
		given()

				.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

				.then().body("CUSTOMER.ID", equalTo("15")).log().all();
	}

	// @Test(priority=2)
	void multipleContents() {
		given()

				.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

				.then().body("CUSTOMER.ID", equalTo("15")).body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
				.body("CUSTOMER.LASTNAME", equalTo("Clancy")).body("CUSTOMER.STREET", equalTo("319 calndy st"))
				.body("CUSTOMER.CITY", equalTo("Seattle"));
		// .log().all();
	}

	// @Test(priority=3)
	void multipleContentsInOneGo() {
		given()

				.when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

				.then().body("CUSTOMER.text()", equalTo("15BillClancy"));

	}

	@Test(priority = 4)
	void testUsingXpath() {
		when().get("http://thomas-bayer.com/sqlrest/CUSTOMER/15").then()
				.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill"))).log().all();

	}

}
