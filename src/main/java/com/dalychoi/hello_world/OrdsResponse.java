package com.dalychoi.hello_world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdsResponse<T> {
	
	private T items;
	private String hasMore;
	
	public OrdsResponse() {
	}
	
	public T getItems() {
		return items;
	}
	public void setItems(T items) {
		this.items = items;
	}
	public String getHasMore() {
		return hasMore;
	}
	public void setHasMore(String hasMore) {
		this.hasMore = hasMore;
	}
	
	@Override
	public String toString() {
		return "OrdsResponse [items=" + items + ", hasMore=" + hasMore + "]";
	}
}
