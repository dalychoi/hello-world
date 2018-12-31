package com.dalychoi.hello_world;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;

import java.util.List;

public class AppTest 
{
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
}
