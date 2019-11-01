package com.company.java.oop.cls;
class ClassB{
	static class Inner{
		static int[] array=new int[1024];
	}
	static int size;
	public static void show() {}
	public static void add(int a) {
		//通过内部类实现对array对象的延迟加载
		if(Inner.array.length==size) {
			System.out.println("容器满了");
			return;
		}
		Inner.array[size]=a;
		size++;
	}
}
//-XX:+TraceClassLoading 
public class TestClassObject05 {
	public static void main(String[] args) {
		//方法类的方法时会导致类的加载
		ClassB.show();
		
	}
}
