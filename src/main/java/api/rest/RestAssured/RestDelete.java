package api.rest.RestAssured;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;
public class RestDelete 
{
	@Test
	public void RestDeleteCall()
	{
		String response=given().
		when().
		delete("https://reqres.in/api/users/2").
		then().
		assertThat().
		statusCode(204).
		and().
		header("Server", equalTo("cloudflare")).
		
		extract().
		response().asString();
		
		System.out.println(response);
	}
}
