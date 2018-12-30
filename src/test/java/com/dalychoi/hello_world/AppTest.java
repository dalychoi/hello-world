package com.dalychoi.hello_world;

import org.springframework.web.client.RestTemplate;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AppTest 
{
    private RestTemplate restTemplate = new RestTemplate();
	private Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

	@Test
	public void testApp()
    {
    	assertThat(quote.getValue(), is(notNullValue()));
    }
}
