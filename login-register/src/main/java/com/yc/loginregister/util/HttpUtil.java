package com.yc.loginregister.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	
	
	public static int Post(String url,HashMap<String,String> paramMap) throws ClientProtocolException, IOException {
		
		HttpUtil httpUtil=new HttpUtil();
		
		CloseableHttpResponse response= httpUtil.PostRequest(url, paramMap);
		
		return httpUtil.getResponseCode(response);
		
	}
	
	
	public static int Get(String url) throws ClientProtocolException, IOException {
		
		HttpUtil httpUtil=new HttpUtil();
		
		CloseableHttpResponse response= httpUtil.GetRequest(url);
		
		return httpUtil.getResponseCode(response);
	}
	

	public CloseableHttpResponse GetRequest(String url) throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(url);
		
		CloseableHttpResponse response = Excute(get);
		
		return response;
	}
	
	public CloseableHttpResponse PostRequest(String url,HashMap<String,String> paramMap) throws ClientProtocolException, IOException {
		
		HttpPost post=new HttpPost();
		
		List<NameValuePair> paramList=new ArrayList<NameValuePair>();
		
		for(String key : paramMap.keySet()) {
			NameValuePair param=new BasicNameValuePair(key,paramMap.get(key));
			paramList.add(param);
		}
		
		HttpEntity reqEntity= new UrlEncodedFormEntity(paramList);
		
		post.setEntity(reqEntity);
		
		CloseableHttpClient  client= HttpClients.createDefault();
		
		CloseableHttpResponse response= client.execute(post);
		
		return response;
		
	}

	public CloseableHttpResponse Excute(HttpUriRequest req) throws ClientProtocolException, IOException {

		CloseableHttpClient client = HttpClients.createDefault();
		
		CloseableHttpResponse response = client.execute(req);
		
		return response;
	}

	public int getResponseCode(CloseableHttpResponse response) {
		
		StatusLine statusline = response.getStatusLine();
		
		return statusline.getStatusCode();
	}
	
	public String getResponseBody(CloseableHttpResponse response) throws ParseException, IOException {
		
		HttpEntity entity= response.getEntity();
		
		return EntityUtils.toString(entity);
	}

}

