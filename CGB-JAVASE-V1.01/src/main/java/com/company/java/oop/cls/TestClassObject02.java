package com.company.java.oop.cls;

public class TestClassObject02 {

	public static void main(String[] args)throws Exception {
		Class<?> c1=Object.class;
		Class<?> c2=Class.forName("java.lang.Object");
		System.out.println(c1==c2);
		//获取类的加载器对象
		ClassLoader appLoader=
		ClassLoader.getSystemClassLoader();
		appLoader.loadClass("java.lang.Object");
		System.out.println(appLoader);
		ClassLoader extLoader=
		appLoader.getParent();
		System.out.println(extLoader);
		ClassLoader bootLoader=
				extLoader.getParent();
		System.out.println(bootLoader);
		
		
		
	}
}
