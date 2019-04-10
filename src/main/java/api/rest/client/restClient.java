package api.rest.client;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.text.html.parser.Entity;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class restClient 
{
	
	//GET method
	public void get(String uri) throws ClientProtocolException, IOException, JSONException
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(uri);//http get request
		CloseableHttpResponse response=httpClient.execute(httpget);//hits the GET url
		//get status code
		int statusCode=response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		//get json String
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject jsonResponse=new JSONObject(responseString);
		
		System.out.println("JSON response from API : "+jsonResponse);
		//All Header
		Header[] headerArray= response.getAllHeaders();
		
		HashMap<String, String> allHeader=new HashMap<String, String>();
		for(Header header:headerArray)
		{
			allHeader.put(header.getName(), header.getValue());
		}
		
		System.out.println("Header array: "+allHeader);
	}
}
