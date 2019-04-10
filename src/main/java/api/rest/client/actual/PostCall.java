package api.rest.client.actual;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PostCall {
	
	public CloseableHttpResponse hitApi(String uri,String entity,HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient closableHttpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(uri);
		
		httpPost.setEntity(new StringEntity(entity));
		
		for(Map.Entry<String, String> entry: headerMap.entrySet())
		{
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse response=closableHttpClient.execute(httpPost);
		
		return response;
	}

}
