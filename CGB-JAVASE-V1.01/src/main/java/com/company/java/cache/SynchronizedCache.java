package com.company.java.cache;

public class SynchronizedCache implements Cache {
	private Cache cache;
	public SynchronizedCache(Cache cache) {
		this.cache=cache;
	}
	@Override
	public synchronized void putObject(Object key, Object value) {
	     cache.putObject(key, value);
	}
	public synchronized Object getObject(Object key) {
		return cache.getObject(key);
	}
	@Override
	public synchronized Object removeObject(Object key) {
		return cache.removeObject(key);
	}
	public static void main(String[] args) {
		SynchronizedCache logCache=
		new SynchronizedCache(new LogCache(new FifoCache(3, new PerpetualCache())));
	    logCache.putObject("A", 100);
	    logCache.putObject("B", 200);
	    logCache.putObject("C", 300);
	    logCache.putObject("D", 300);
	    logCache.getObject("A");
	    logCache.getObject("B");
	}
}
