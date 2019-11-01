package com.company.java.oop.cls;
import java.lang.reflect.Constructor;
/**此工厂要基于类的字节码对象创建实例对象*/
class ObjectFactory{
	public static Object newInstance(Class<?> cls)
	throws Exception{
		//return cls.newInstance();//局限性(必须有无参构造，且是public修饰)
//		//基于字节码对象获取类的无参构造函数对象
//		Constructor<?> con=
//		cls.getDeclaredConstructor();
//		//假如无参构造函数不可访问，则设置可访问
//		if(!con.isAccessible())
//			con.setAccessible(true);
//		//基于构造方法对象构建类的实例对象
//		return con.newInstance();
		return newInstance(cls, null, null);
	}
	public static Object newInstance(
		Class<?> cls,Class<?>[]parameterTypes,Object[]initargs)
			throws Exception{
		//基于字节码对象获取类中指定参数的构造函数对象
		Constructor<?> con=
		cls.getDeclaredConstructor(parameterTypes);
		//假如无参构造函数不可访问，则设置可访问
		if(!con.isAccessible())
			con.setAccessible(true);
		//基于构造方法对象构建类的实例对象，并传入实际参数
		return con.newInstance(initargs);
	}
}
public class TestClassObject04 {
	static class ClassAA{
		private ClassAA(){}
	}
	static class ClassAB{
		private ClassAB(int b){}
	}
	public static void main(String[] args)throws Exception {
		//获取Date类型的字节码对象，并基于此对象创建其实例
		Class<?> c1=
		Class.forName("java.util.Date");
		Object o1=ObjectFactory.newInstance(c1);
		System.out.println(o1);
		//获取ClassAA类型的字节码对象，并基于此对象创建其实例
		Class<ClassAA> c2=ClassAA.class;
		Object o2=
		ObjectFactory.newInstance(c2);
		System.out.println(o2);
		//获取ClassAB类型的字节码对象，并基于此对象创建其实例
		Class<ClassAB> c3=ClassAB.class;
		Object o3=
		ObjectFactory.newInstance(c3,new Class[] {int.class},new Object[] {10});
		System.out.println(o3);
	}
}
