package com.qa.httpprest.apiTests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.httpprest.base.TestBase;
import com.qa.httpprest.client.RestClient;
import com.qa.httpprest.util.TestUtil;

public class GetAPITest extends TestBase {
	TestBase testBase;
	String mainurl;
	String serviceurl;
	String url;
	CloseableHttpResponse closeableHttpResponse;
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase = new TestBase();

		mainurl = testBase.getValue("MainURL");

		serviceurl = testBase.getValue("serviceUrl");
		url = mainurl + serviceurl;
	}

	@Test
	public void testGet() throws ClientProtocolException, IOException {
		RestClient restClient = new RestClient();
		closeableHttpResponse=restClient.get(url);
		
		int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		String response = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

		JSONObject jsonObject = new JSONObject(response);
		System.out.println(jsonObject);

		Header[] hearderArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : hearderArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println(allHeaders);
		
		String pageNumber=TestUtil.getValueByJPath(jsonObject, "per_page");
		System.out.println(pageNumber);
		
		String total=TestUtil.getValueByJPath(jsonObject, "total");
		System.out.println(total);
		
		String lastname=TestUtil.getValueByJPath(jsonObject, "data[0]/last_name");
		System.out.println(lastname);
		
		
	}
}
