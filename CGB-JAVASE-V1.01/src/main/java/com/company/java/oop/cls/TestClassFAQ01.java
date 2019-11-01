package com.company.java.oop.cls;
class Outer{
	class Inner{}
}
public class TestClassFAQ01 {
	public static void main(String[] args)
	throws Exception{
		Class<?> c1=
		Class.forName("com.company.java.oop.cls.Outer$Inner");
		System.out.println(c1);
	}
}
