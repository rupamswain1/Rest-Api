package api.rest.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestPost {

	@Test
	public void Post() throws JSONException
	{
		RestAssured.baseURI="https://reqres.in//api/users";
		RequestSpecification reqSpec=RestAssured.given();
		
		JSONObject requestParm=new JSONObject();
		requestParm.put("name", "Race");
		requestParm.put("job", "Automation expert");
		
		reqSpec.body(requestParm.toString());
		Response response=reqSpec.post();
		
		int status=response.getStatusCode();
		System.out.println(status);
		System.out.println(response.getHeader("Server"));
		System.out.println(response.getBody());
		
		
	}
	@Test
	public void PostCall() throws JSONException
	{
		JSONObject json=new JSONObject();
		json.put("name", "Test");
		json.put("job", "tester");
		
		String response=given().
		when().
		body(json.toString()).
		post("https://reqres.in/api/users").
		then().
		assertThat().
		statusCode(201).and().
		/*body("id[0]",equalTo(3)).
		and().*/
		header("Server", equalTo("cloudflare")).
		extract().response().asString();
		System.out.println(response);
	}
	
	
	
}
