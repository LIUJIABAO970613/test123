package com.company.java.oop.abs;
final class DUtil{
	private DUtil() {}
	public static void show() {}
}
//当现在有一个工具类，
//此类中所有方法都是静态的，
//JDK以后推荐使用接口
interface ID{
	/**
	 * JDK8以后在接口中允许直接定义静态方法
	 */
	public static void show() {}
}
public class TestInterface02 {
    public static void main(String[] args) {
		ID.show();
	}
}
