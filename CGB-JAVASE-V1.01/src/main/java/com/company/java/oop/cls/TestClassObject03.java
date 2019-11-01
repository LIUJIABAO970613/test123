package com.company.java.oop.cls;
class ClassA{
	static {
		System.out.println("static{}");
	}
}
//-XX:+TraceClassLoading
public class TestClassObject03 {

	public static void main(String[] args)throws Exception {
		//Class<?> c1=ClassA.class;
//		Class<?> c2=
//		Class.forName("com.company.java.oop.ClassA");
		Class<?> c3=
		Class.forName("com.company.java.oop.ClassA",
				false,//true时执行static{}
				ClassLoader.getSystemClassLoader());
	}
}
