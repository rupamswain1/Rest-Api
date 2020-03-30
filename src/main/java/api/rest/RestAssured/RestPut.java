package api.rest.RestAssured;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class RestPut 
{
	@Test
	public void PutCall() throws JSONException
	{
		JSONObject json=new JSONObject();
		json.put("name", "rupam");
		json.put("job", "tester");
		
		String response=	
		given().
		when().
		body(json.toString()).
		put("https://reqres.in/api/users/2").
		then(). 
		assertThat().
		statusCode(200).
		extract().response().asString();
		System.out.println(response);
	}
}
