package com.company.java.args;
//可变参数
public class TestVarArgs01 {
//	static void doMethod(int a) {}
//	static void doMethod(int a,int b) {}
//	static void doMethod(int a,int b,int c) {}
    //可变参数(必须三个点),可将可变参数理解为特殊数组
	static void doMethod(int... args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
	}
	//可变参数必须作为形参的最后一个参数出现
	static void doMethod(String s,int... a) {}
	public static void main(String[] args) {
		doMethod();
		doMethod(10);
		doMethod(10,20);
		doMethod(10,20,30);
		doMethod(10,20,30,40);
	}
}
