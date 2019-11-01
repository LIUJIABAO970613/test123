package com.company.java.cache;
/**Cache接口：定义缓存数据的标准*/
public interface Cache {
	/**
	 * 存储数据
	 * @param key
	 * @param value
	 */
	public void putObject(Object key,Object value);
	/**
	 * 取数据
	 * @param key
	 * @return
	 */
	public Object getObject(Object key);
	/**
	  *  基于key移除元素
	 * @param key
	 * @return
	 */
	public Object removeObject(Object key);
	
}






