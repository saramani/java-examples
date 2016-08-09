package com.javaexamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<Key, Value> extends LinkedHashMap<Key, Value> {

	private static final long serialVersionUID = 1L;
	
	private final int size; // size of the cache

	public LRUCache(final int maxEntries)   
	   {  
	      // super(maxEntries + 1, 1.0f, true); // 1.0 is the loadFactor or in cheap words how much each bucket/slot will be filled in the hashtable  
	       this.size = maxEntries;  
	   }

	/**
	 * @see java.util.LinkedHashMap#removeEldestEntry(Map.Entry)
	 */
	protected boolean removeEldestEntry(final Map.Entry<Key, Value> oldest) {
		return super.size() > size;
	}
	
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(1);
		lruCache.put("1", "One");
		lruCache.put("2", "Two");
		lruCache.put("3", "Three");
		lruCache.forEach((k,v) -> {
			System.out.println("(k, V)" + k + "," +  v);
		});
	}
}