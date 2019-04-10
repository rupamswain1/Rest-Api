package api.rest.qa;
import org.testng.annotations.Test;

import api.rest.client.restClient;
import api.rest.test.ReadProperty;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.AfterTest;

public class apiTest {
	
	String uri=null;
  @Test
  public void f() throws ClientProtocolException, IOException, JSONException {
	  new restClient().get(uri);
  }
  @BeforeTest
  public void beforeTest() {
	 uri= ReadProperty.read("url")+ReadProperty.read("serviceUrl");
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
