package com.company.java.generic;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class TestGeneric06 {
	public static void main(String[] args) throws Exception {
		List<String> list=new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(100);
		//在运行时将100写入到list集合
		//1.获取list对象的字节码对象
		Class<?> cls=list.getClass();
		//2.获取list字节码对象中的add方法对象
		Method method=
		//cls.getDeclaredMethod("add",Object.class);
		cls.getDeclaredMethod("add",int.class,Object.class);
		//3.通过反射执行方法对象将100写入集合。
		//执行list对象的method方法
		//method.invoke(list, 100);
		method.invoke(list, 0,100);
		method.invoke(list,0,true);
		System.out.println(list);
	}
}
