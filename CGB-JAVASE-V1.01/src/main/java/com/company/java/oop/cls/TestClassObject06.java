package com.company.java.oop.cls;
/**
 * 何时会触发类加载？
 * 1)使用类加载器直接加载。
 * 2)构建本类或这个类的子类对象时。
 * 3)访问类中成员时(包含属性和方法)，但也有特殊情况
 * 3.1)访问类中使用static final修饰的8种
 * 基本数据类型以及字符串类型时不会触发类的加载。
 */
class ClassC{
	static int a=10;//会触发类加载
	static final int b=20;//不会触发类加载
	static final String s="CGB1906";//不会触发类加载
	static final Integer c=30;
	static {
		System.out.println("ClassC");
	}
}
//当通过子类访问父类成员时，假如会触发类加载
//那么父类为主动加载，子类为被动加载
//被动加载的类不会执行静态代码块。
class ClassCC extends ClassC{
	static Double d1=10.2;
	static {
		System.out.println("ClassCC");
	}
}
class ClassCCC extends ClassCC{
	static {
		System.out.println("ClassCCC");
	}
}
//-XX:+TraceClassLoading
public class TestClassObject06 {
    public static void main(String[] args) {
    	//此访问会加载父类，子类，
    	//但不会执行ClassCC的静态代码块
		//int a=ClassCCC.c;
    	double d=ClassCCC.d1;
	}
}





