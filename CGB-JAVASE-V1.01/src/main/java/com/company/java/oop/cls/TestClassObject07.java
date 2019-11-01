package com.company.java.oop.cls;
/**
 * 静态属性和静态代码的初始化顺序由定义决定，
 */
class ClassD{
	static ClassD instance=new ClassD();
	public ClassD() {
		System.out.println("ClassD()");
	}
	int a;
	{//实例代码块(每次构建对象实例，此代码块都会执行)
		System.out.println("{}");
	}
	static {
		System.out.println("static{}");
	}
	public static void show() {}
}
public class TestClassObject07 {
    public static void main(String[] args) {
		ClassD.show();
	}
}
