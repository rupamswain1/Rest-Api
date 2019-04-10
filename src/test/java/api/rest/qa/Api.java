package api.rest.qa;

import java.io.IOException;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.rest.client.actual.BaseClass;
import api.rest.test.ReadProperty;

public class Api {
 
	String uri=null;
	 @BeforeTest
	  public void beforeTest() {
		 uri= ReadProperty.read("url")+ReadProperty.read("serviceUrl");
		  
	  }
	
  @Test
  public void f() throws ParseException, IOException, JSONException {
	  BaseClass base=new BaseClass();
	  base.hitApi(uri);
	  System.out.println(base.getResponse());
	  System.out.println(base.getJason());
	  System.out.println(base.getHeader());
  }
}
