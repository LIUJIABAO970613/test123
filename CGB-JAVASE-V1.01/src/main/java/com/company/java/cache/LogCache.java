package com.company.java.cache;
/**
  * 此Cache对象要在Cache的基础上添加日志操作，
  *  例如记录元素的命中率(命中次数/请求次数)
 * @author Administrator
 *
 */
public class LogCache implements Cache {
	private Cache cache;
	/**请求次数*/
	private int requests;
	/**命中次数*/
	private int hit;
	public LogCache(Cache cache) {
		this.cache=cache;
	}
	@Override
	public void putObject(Object key, 
			Object value) {
	    cache.putObject(key, value);
	}
	@Override
	public Object  getObject(Object key) {
		//1.记录请求次数
		requests++;
		//2.从cache取数据
		Object obj=cache.getObject(key);
		//3.记录命中次数
		if(obj!=null)hit++;
		//4.输出命中率
		System.out.println("request hits "+hit*1.0/requests);
		return obj;
	}
	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}
	public static void main(String[] args) {
		LogCache logCache=
		new LogCache(new FifoCache(3,new PerpetualCache()));
	    logCache.putObject("A", 100);
	    logCache.putObject("B", 200);
	    logCache.putObject("C", 300);
	    logCache.getObject("A");
	    logCache.putObject("D", 300);
	    logCache.getObject("A");
	    logCache.getObject("B");
	}
}





