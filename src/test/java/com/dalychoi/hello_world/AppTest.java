package com.dalychoi.hello_world;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;

import java.util.List;

public class AppTest 
{
	@Before
	public void setProxy()
	{
		System.setProperty("http.proxyHost",  "www-proxy.jp.oracle.com");
		System.setProperty("http.proxyPort",  "80");
		System.setProperty("https.proxyHost",  "www-proxy.jp.oracle.com");
		System.setProperty("https.proxyPort",  "80");
		System.setProperty("http.nonProxyHosts",  "10.179.*|localhost|127.0.0.1");
	}
	
	@Test
	public void testApp()
	{
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		assertThat(quote.getValue(), is(notNullValue()));
	}
	
	@Test
	public void testJsonArrayApp()
	{
		RestTemplate restTemplate = new RestTemplate();
		// get json array
		ResponseEntity<List<Post>> response = restTemplate.exchange(
			"https://jsonplaceholder.typicode.com/posts?userId=1",
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<Post>>() {}
		);
		List<Post> posts = response.getBody();
		assertThat(posts.size(), greaterThan(0));
	}
	
	@Test
	public void testJsonArray2App()
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrdsResponse<List<Customer>>> response2 = restTemplate.exchange(
			"http://10.179.94.211:8080/ords/soe2/cust/customers",
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<OrdsResponse<List<Customer>>>() {}
		);
		OrdsResponse<List<Customer>> ordsResponse = response2.getBody();
		List<Customer> customers = ordsResponse.getItems();
		assertThat(customers.size(), greaterThan(0));
	}
}
