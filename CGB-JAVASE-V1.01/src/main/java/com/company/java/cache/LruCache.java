package com.company.java.cache;
import java.util.LinkedHashMap;
import java.util.Map;
//mybatis
public class LruCache implements Cache {
	/**存储数据的cache对象*/
	private final Cache delegate;
	/**记录key的访问顺序*/
	private Map<Object, Object> keyMap;
	/**最不经常访问的元素*/
    private Object eldestKey;
    public LruCache(Cache delegate) {
        this.delegate = delegate;
        setSize(3);
    }
    public void setSize(final int size) {
        keyMap = new LinkedHashMap<Object, Object>(size, .75F, true) {
          private static final long serialVersionUID = 4267176411845948333L;
          @Override
          protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
            boolean tooBig = size() > size;
            if (tooBig) {
              eldestKey = eldest.getKey();
            }
            return tooBig;
          }
        };
    }
	@Override
	public void putObject(Object key, Object value) {
	  delegate.putObject(key, value);
	  removeOldObject(key);
	}
	 private void removeOldObject(Object key) {
		    keyMap.put(key, key);
		    if (eldestKey != null) {
		      delegate.removeObject(eldestKey);
		      eldestKey = null;
		    }
	 }

	@Override
	public Object getObject(Object key) {
		  keyMap.get(key); //touch
		  return delegate.getObject(key);
	}

	@Override
	public Object removeObject(Object key) {
	   keyMap.remove(key);
	   return delegate.removeObject(key);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return delegate.toString();
	}
	public static void main(String[] args) {
		//1.构建Cache对象
		LruCache cache=
		new LruCache(new PerpetualCache());
		//2.存储数据
		cache.putObject("A", 100);
		cache.putObject("B", 200);
		cache.putObject("C", 300);
		cache.getObject("A");
		//cache.removeObject("A");
		cache.putObject("D", 400);
		System.out.println(cache);
	}

}
