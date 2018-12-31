package com.dalychoi.hello_world;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

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
		
		// get json array
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Post>> response = restTemplate.exchange(
			"https://jsonplaceholder.typicode.com/posts?userId=1",
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<Post>>() {}
		);
		List<Post> posts = response.getBody();
		System.out.println("Count of posts: " + posts.size());
		for (Post post : posts) {
			System.out.println(post.toString());
		}
	}
}
