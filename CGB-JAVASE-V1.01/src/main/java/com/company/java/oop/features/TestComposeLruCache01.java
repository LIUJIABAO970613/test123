package com.company.java.oop.features;

import java.util.LinkedHashMap;
import java.util.Map;
//组合方式的LRUCache
class ComposeLruCache{
	private LinkedHashMap<String,Object> cache;
	public ComposeLruCache(int initialCapacity) {
		cache=new LinkedHashMap<String, Object>(
			initialCapacity,0.75f,true){
			private static final long serialVersionUID = -8656072263242602764L;
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, Object> eldest) {
				return size()>initialCapacity;
			}
		};
	}
	public void putObject(String key,Object value) {
		cache.put(key, value);
	}
	public Object getObject(String key) {
		return cache.get(key);
	}
	@Override
	public String toString() {
		return cache.toString();
	}
}
public class TestComposeLruCache01 {
    public static void main(String[] args) {
		ComposeLruCache cache=new ComposeLruCache(3);
		cache.putObject("A", 100);
		cache.putObject("B", 200);
		cache.putObject("C", 300);
		cache.getObject("A");
		cache.putObject("D", 300);
		System.out.println(cache);
	}
}





