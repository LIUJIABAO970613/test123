package com.company.java.cache;

import com.company.java.exception.CacheException;
import com.company.java.serializable.KryoUtil;

public class KryoSerializedCache implements Cache{
	private Cache cache;
	public KryoSerializedCache(Cache cache) {
		this.cache=cache;
	}
	@Override
	public void putObject(Object key, Object value) {
		try {
		 //1.序列化
		 byte array[]=KryoUtil.serialize(value);
		 //2.写缓存
		 cache.putObject(key, array);
		}catch(Exception e) {
		 throw new CacheException("序列化异常");
		}
	}
	@Override
	public Object getObject(Object key) {
		//1.读缓存
		byte[] array=(byte[])cache.getObject(key);
		//2.反序列化
		return KryoUtil.deserialize(array);
	}
	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}
}
