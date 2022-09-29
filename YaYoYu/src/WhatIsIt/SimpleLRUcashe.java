package WhatIsIt;

import java.util.LinkedHashMap;
import java.util.Map;

//Simple LRU cashe — least recently used
public class SimpleLRUcashe<K, V> extends LinkedHashMap<K, V> {
	private final int capacity;
	
	public SimpleLRUcashe (int capacity) {
		super(capacity + 1, 1.1f, true);
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return this.size() > capacity;
	}
}
