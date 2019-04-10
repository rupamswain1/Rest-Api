package api.rest.client.actual;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseClass {
	
	CloseableHttpResponse closableHttpResponse=null;
	
	public void hitApi(String uri)
	{
		CloseableHttpClient closableHttpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(uri);
		try {
			closableHttpResponse=closableHttpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	public int getResponse()
	{
		return closableHttpResponse.getStatusLine().getStatusCode();
	}
	
	public JSONObject getJason() throws ParseException, IOException, JSONException
	{
		String response=EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");
		JSONObject Jobj=new JSONObject(response);
		return Jobj;
	}
	
	public HashMap<String, String> getHeader()
	{
		Header[] headerArray=closableHttpResponse.getAllHeaders();
		HashMap<String, String> headerHashMap=new HashMap<String, String>();
		for(Header header:headerArray)
		{
			headerHashMap.put(header.getName(), header.getValue());
		}
		return headerHashMap;
			
	}

}
