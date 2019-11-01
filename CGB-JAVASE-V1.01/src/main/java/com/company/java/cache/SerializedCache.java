package com.company.java.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.company.java.exception.CacheException;

/**
 * SerializedCache 操作实现：
 * 
 * 	序列化存储操作
 * 	1)step01:将对象序列化为字节
 * 	2)Step02:将字节存储到缓存
 * 
 * 	反序列化操作：
 *	1)将字节从缓存读出来
 *	2)将字节转换为对象
 */
public class SerializedCache implements Cache {
    private Cache cache;
    public SerializedCache(Cache cache) {
    	this.cache=cache;
	}
    //反序列化
    private Object deserialize(byte[] array)throws IOException, ClassNotFoundException {
    	//1.构建流对象
    	//1.1构建字节数组输入流
    	ByteArrayInputStream bis=
    	new ByteArrayInputStream(array);
    	//1.2构建对象输入流对象
    	ObjectInputStream ois=
    	new ObjectInputStream(bis);
    	//2.对象反序列化
    	Object obj=ois.readObject();
    	//3.释放资源
    	bis.close();
    	ois.close();
    	return obj;
    }
    //序列化
    private byte[] serialize(Object object)throws IOException {
    	//1.构建输出流对象
    	//1.1构建字节数组输出流，内置一个可扩容的数组
    	ByteArrayOutputStream bos=
    	new ByteArrayOutputStream();
    	//1.2构建对象流对象
    	ObjectOutputStream oos=
    	new ObjectOutputStream(bos);
    	//2.将对象序列化(将对象转换为字节存储到bos对应的数组中)
    	oos.writeObject(object);
    	oos.flush();
    	byte[] array=bos.toByteArray();
    	//3.释放资源
    	bos.close();
    	oos.close();
    	return array;
    }
    /**向cache存对象:序列化方式存储*/
	@Override
	public void putObject(Object key, Object value){
		try {
	     //1.序列化
		 byte[] array=serialize(value);
		 //2.存储到cache
		 cache.putObject(key, array);//HashMap
		}catch(Exception e) {
		 e.printStackTrace();
		 throw new CacheException("序列化存储异常");
		}
	}
    /**从cache读数据:将cache中的数据反序列化*/
	@Override
	public Object getObject(Object key) {
		//从cache取
		byte[] array=(byte[])cache.getObject(key);
		try {
		//反序列化
		return array==null?null:deserialize(array);
		}catch (Exception e) {
		e.printStackTrace();
		throw new CacheException("反序列化对象异常");
		}
	}
	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}
}
