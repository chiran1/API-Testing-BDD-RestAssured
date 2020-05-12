package RestAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class TC003_PUT_Request {

	public static HashMap map = new HashMap();
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	int empId = 3;

	@BeforeClass
	public void putData() {
		map.put("employee_name", empName);
		map.put("employee_salary", empSalary);
		map.put("employee_age", empAge);

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/" + empId;

	}

	@Test
	public void testPUT() {
		given().contentType("application/json").body(map).when().put().then().statusCode(200).log().all();

	}

}
