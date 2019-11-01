package com.company.java.cache;
import java.util.HashMap;
import java.util.Map;
/**永久cache:不设计缓存淘汰策略，不记录元素顺序*/
public class PerpetualCache implements Cache {
	private Map<Object,Object> cache=
			new HashMap<>();
	@Override
	public void putObject(Object key, Object value) {
	      cache.put(key, value);
	}
	@Override
	public Object getObject(Object key) {
		return cache.get(key);
	}
	@Override
	public Object removeObject(Object key) {
		return cache.remove(key);
	}
	@Override
	public String toString() {
		return cache.toString();
	}
}
