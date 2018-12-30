package com.dalychoi.hello_world;

import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RestTemplate restTemplate = new RestTemplate();
    	Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    	System.out.println(quote.toString());
    }
}
