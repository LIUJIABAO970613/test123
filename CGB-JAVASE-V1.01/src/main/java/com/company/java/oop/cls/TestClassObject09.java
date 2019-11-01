package com.company.java.oop.cls;
class ClassF{
	static ClassF instance=new ClassF();
	public ClassF() {
		System.out.println(b);
	}
	static final int b=10;
}
public class TestClassObject09 {
	public static void main(String[] args) 
	throws Exception{
		Class.forName("com.company.java.oop.cls.ClassF");
	}
}
