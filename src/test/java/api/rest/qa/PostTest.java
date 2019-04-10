package api.rest.qa;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.rest.bean.PostUser;
import api.rest.client.actual.PostCall;
import api.rest.test.ReadProperty;

public class PostTest {

	String uri=null;
	@BeforeClass
	public void initialize()
	{
		this.uri=ReadProperty.read("url")+ReadProperty.read("serviceUrl");
	}
	
	@Test
	public void PostcallTest() throws JsonGenerationException, JsonMappingException, IOException, JSONException
	{
		PostCall post=new PostCall();
		String entity=null;
		HashMap<String, String> headerMap=new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//jackson
		ObjectMapper mapper=new ObjectMapper();
		PostUser user=new PostUser("rupam", "test engineer");
		
		//Object to json file
		System.out.println(System.getProperty("user.dir"));
		mapper.writeValue(new File(System.getProperty("user.dir")+"//src//main//resources//newJason.json"), user);
		
	//object to json in String
		String jsonSreing=mapper.writeValueAsString(user);
		System.out.println(jsonSreing);
		
		CloseableHttpResponse reponse=post.hitApi(this.uri, jsonSreing, headerMap);
		
		//Status code
		
		int code=reponse.getStatusLine().getStatusCode();
		System.out.println("Status : "+ code);
		
		String jasonString=EntityUtils.toString(reponse.getEntity(),"UTF-8");
		JSONObject Jobject=new JSONObject(jasonString);
		System.out.println("JASON->"+Jobject);
		
		//json to java
		PostUser userobj=mapper.readValue(jasonString, PostUser.class);
		System.out.println(userobj);
		
		System.out.println(userobj.name);
		System.out.println(userobj.job);
	}




}


