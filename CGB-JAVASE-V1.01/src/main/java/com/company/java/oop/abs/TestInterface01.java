package com.company.java.oop.abs;
interface IA{
    /*public static final*/ int a=100;
    /*public abstract*/ void doMethod();
}
/** JDK8中允许存在default方法
 * 	特点：
 *	 1)适用default关键字修饰
 *   2)可以有方法实现
 *	场景：
 *   1)扩展目标接口，子类无需做任何修改
 *   2)取代使用抽象类做默认空方法的实现(不再需要抽象类作为适配器)
 *    案例分析：
 *  jdk8:Collection接口,....
 */
interface IB{
	default void doMethod01() {
		System.out.println("doMethod01");
	}
	default void doMethod02() {
		System.out.println("doMethod02");
	}
	void doMethod03();
	
}
class A implements IA{
	
	public void doMethod() {
	}
}
class B implements IB{
	@Override
	public void doMethod03() {
	}
}
public class TestInterface01 {
	public static void main(String[] args) {
		// IA a1=new IA();//错
		   IA a2=new A();
		// IB b1=new IB();//错
		   IB b2=new B();
		   b2.doMethod01();
	}
}
