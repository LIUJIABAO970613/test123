package com.company.java.oop.abs;
/**
  *   函数式接口:需要使用@FunctionalInterface修饰
  *    特点：
 *  1)必须有一个抽象方法定义,且只能有一个。
 *  2)可以有多个default方法，static方法
  *    应用场景：配合拉姆达(LAMBDA)表达式应用
 */
@FunctionalInterface
interface IE{
	void show();
	//void display();
	default void display() {}
	default void dance() {}
}
public class TestInterface03 {
	static void doMethod(IE e) {
		e.show();
	}
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello thread-01");
			}
		}).start();
		new Thread(()->{//LAMBDA
			System.out.println("hello thread 02");
		}).start();  
		
		doMethod(new IE() {
			@Override
			public void show() {
				System.out.println("show-01");
			}
		});
		doMethod(()->{
			System.out.println("show-02");
		});
	}
}
