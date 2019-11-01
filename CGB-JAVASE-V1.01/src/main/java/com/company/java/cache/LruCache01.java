package com.company.java.cache;
import java.util.Deque;
import java.util.LinkedList;
/**
  * 此cache本身不存数据，只负责提供缓存淘汰算法
 */
public class LruCache01 implements Cache {
	/**组合Cache接口*/
    private Cache cache;
    /**借助此对象存储key的添加顺序*/
    private Deque<Object> keyOrderList;
    /**最大容量*/
    private int maxCap;
    public LruCache01(int maxCap,Cache cache) {
    	this.maxCap=maxCap;
    	this.cache=cache;
    	keyOrderList=new LinkedList<Object>();
	}
	@Override
	public void putObject(Object key, Object value) {
		//1.记录key
		keyOrderList.addLast(key);
		//2.移除老元素
		if(keyOrderList.size()>maxCap) {
			Object oldKey=
			keyOrderList.removeFirst();
			cache.removeObject(oldKey);
		}
		//3.放新元素
		cache.putObject(key, value);
	}
	@Override
	public Object getObject(Object key) {
		Object obj=cache.getObject(key);
		if(obj!=null) {
			keyOrderList.remove(key);
			keyOrderList.addLast(key);
		}
		return obj;
	}
	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}
	@Override
	public String toString() {
		return cache.toString();
	}
	
	public static void main(String[] args) {
		//1.构建Cache对象
		LruCache01 cache=
		new LruCache01(2, new PerpetualCache());
		//2.存储数据
		cache.putObject("A", 100);
		cache.putObject("B", 200);
		cache.getObject("A");
		cache.putObject("C", 300);
		System.out.println(cache);
		
	}

}
