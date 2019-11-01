package com.company.java.oop.features;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
class FifoCache{
	/**基于此属性记录key的顺序*/
	private LinkedList<String> keyOrderList=
		new LinkedList<String>();
	/**基于此map对象实现数据的缓存*/
	private Map<String,Object> cache=
		new HashMap<String, Object>();
    /**记录容器的最大容量*/
	private int maxCap;
	public FifoCache(int maxCap) {
		this.maxCap=maxCap;
	}
	public void put(String key,Object value) {
		//1.存储key
		keyOrderList.addLast(key);
	    //2.检测cache是否已满，满了则移除元素
		if(keyOrderList.size()>maxCap) {
			String oldKey=
			keyOrderList.removeFirst();
		    cache.remove(oldKey);
		}
		//3.将key/value存储到cache
		cache.put(key, value);
	}
	public Object get(String key) {
		return cache.get(key);
	}
	@Override
	public String toString() {
		return cache.toString();
	}
}
public class TestComposeFifoCache01 {
	public static void main(String[] args) {
		FifoCache cache=new FifoCache(3);
		cache.put("A", 100);
		cache.put("B", 200);
		cache.put("C", 300);
		cache.put("D", 400);
		cache.put("E", 500);
		System.out.println(cache);
	}
}




