package com.company.java.oop.instance;
//JVM参数
//最大堆:-Xmx10m
//最小堆:-Xms10m 
//对象逃逸分析:-XX:+DoEscapeAnalysis 
//输出GC信息:-XX:+PrintGC
//测试 -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
//JDK8-HotSpot 逃逸分析默认是开启的。
public class TestInstanceObject01 {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		for(int i=0;i<100000000;i++) {
			createBuf();
		}
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	//static byte[]buf;
	static void createBuf() {
		//小对象，没有逃逸,可能会存在栈中
		byte[] buf=new byte[2];
		buf[0]=1;
	}//栈上分配的优势：对象销毁无需启动GC
}
