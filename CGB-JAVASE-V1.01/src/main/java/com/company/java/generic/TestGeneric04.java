package com.company.java.generic;
import java.util.Collection;
import java.util.Date;
/**
 * 	泛型方法应用
 *	基于工厂为任意类型创建对象
 */
class ObjectFactory{
	 //泛型方法
	 public <T>T newInstance(Class<T> cls)
	 throws Exception{
		 return cls.newInstance();
	 }
	 /**判定一个对象是否是Collection类型*/
	 public <T>boolean isCollection(Class<T> cls) {
		 return Collection.class.isAssignableFrom(cls);
	 }
}
public class TestGeneric04 {
    public static void main(String[] args)
    throws Exception{
	    ObjectFactory of=new ObjectFactory();
	    Date obj=of.newInstance(Date.class);
	    System.out.println(obj.getTime());
    }
}
