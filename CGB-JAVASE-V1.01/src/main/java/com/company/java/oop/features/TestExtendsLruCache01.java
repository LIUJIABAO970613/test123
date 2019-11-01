package com.company.java.oop.features;
import java.util.LinkedHashMap;
/**
 * LinkedHashMap 简介
 * 1)存储结构：链表+散列表
 * 2)存储算法：LRU+哈希算法
 * LinkedHashMap 特性
 * 1)记录元素的添加顺序，访问数据。
 * 2)线程不安全
 * LRU(Least Recently Used Cache)算法：缓存淘汰算法(最近最少适用算法)
 */
class LruCache extends LinkedHashMap<String,Object>{
	private static final long serialVersionUID = -2487690822899844666L;
    private final int maxCap;//最大容量
	public LruCache(int initialCapacity,
			float loadFactor,
			boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
		this.maxCap=initialCapacity;
	}
	/**每次执行put方法底层都会调用此方法进行判定*/
	protected boolean removeEldestEntry(
	 java.util.Map.Entry<String,Object> eldest) {
		return size()>maxCap;
	};
}
public class TestExtendsLruCache01 {

	 public static void main(String[] args) {
		LruCache cache=
		//true表示记录访问顺序，默认是添加顺序
		new LruCache(3,0.75f,true);
		cache.put("A", 100);
		cache.put("D", 200);
		cache.put("C", 300);
		cache.put("B", 400);
		cache.get("D");
		System.out.println(cache);
	}
}








