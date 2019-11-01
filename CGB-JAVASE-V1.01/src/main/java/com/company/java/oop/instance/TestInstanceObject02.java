package com.company.java.oop.instance;
class ClassA{
	//对象被回收前会执行finalize()方法
	@Override
	protected void finalize() throws Throwable {
		System.out.println("ClassA.finalize()");
	}
}
//-Xmx5m -Xms5m -XX:+PrintGCDetails
public class TestInstanceObject02 {
	public static void main(String[] args) {
		ClassA c1=new ClassA();
		c1=null;//此时ClassA的实例对象不达
		//手动GC(系统底层会对对象进行"可达性"分析)
		//System.gc();
		byte[]buf1=new byte[1024*1024];
		byte[]buf2=new byte[1024*1024];
		byte[]buf3=new byte[1024*1024];
		byte[]buf4=new byte[1024*1024];
//		byte[]buf5=new byte[1024*1024];
	}
}
