package api.rest.RestAssured;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class RestAssuredGet {

@Test
public void RestGetCall()
{
	String response=
	given().
	when().
	get("https://reqres.in/api/users?page=3").
	then().
	assertThat().
	statusCode(200).and().
	body("data.id",hasSize(3)).
	and().
	header("Server", equalTo("cloudflare")).
	and().
	body("page", equalTo(3)).
	and().
	body("data.first_name[1]",equalTo("Lindsay")).
	extract().
	response().asString();
	
	System.out.println(response);
}
	
}
