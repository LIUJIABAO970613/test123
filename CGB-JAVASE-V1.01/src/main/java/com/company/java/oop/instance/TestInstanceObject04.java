package com.company.java.oop.instance;
/**
 * 如何设计，才能保证如下类的实例对象
 * 在内存中只有一份？
 * 1)让外界从一个池中去取对象(通过池保证类的实例在池中一份)
 * 2)让外界直接通过类的静态方法获取类内部创建的一个实例。
 */
class Singleton01{//应用场景：小对象,高并发
	private static Singleton01 instance=new Singleton01();
	private Singleton01() {}
	public static Singleton01 getInstance() {
		return instance;
	}
}
class Singleton02{//适合场景：大对象，单线程
	private Singleton02() {
		System.out.println("Singleton02()");
	}
	private static Singleton02 instance;
	/**
	 * 线程不安全？导致线程不安全的原因是什么？
	 * 1)多个线程并发执行
	 * 2)多个线程有共享数据集(例如instance)
	 * 3)多个线程在共享数据上的操作不是原子操作。
	 * @return
	 */
	public static Singleton02 getInstance() {
		if(instance==null) {
			instance=new Singleton02();
		}
		return instance;
	}
}
class Singleton03{//适合场景：大对象，多线程，性能要求不高
	private Singleton03() {
		System.out.println("Singleton02()");
	}
	private static Singleton03 instance;
	public static synchronized Singleton03 getInstance() {
		if(instance==null) {
			instance=new Singleton03();
		}
		return instance;
	}
}

class Singleton04{//适合场景：大对象，线程不多，性能要求不高
	private Singleton04() {
		System.out.println("Singleton04()");
	}
	/**volatile 关键字的作用
	 * 1)禁止指令重排序(JVM对java程序进行编译时会有指令重排序的现象)
	 * 2)保证可见性(多CPU，一个线程的对某个共享变量的修改对另一个线程是可见的)
	 * 3)但不保证原子性（synchronized可以保证）。
	 */
	private static volatile Singleton04 instance;
	/**
	 * 优化：在保证线程安全的情况下尽量减少线程阻塞。
	 * @return
	 */
	public static  Singleton04 getInstance() {
		if(instance==null) {
		 synchronized (Singleton04.class) {
		  if(instance==null) {
			instance=new Singleton04();
		    //1.分配空间
			//2.对象属性初始化
			//3.执行构造方法
			//4.将对象赋值给instance变量
		  }
		 }
		}
		return instance;
	}
}
class Singleton05{//适用场景:大对象，高并发，高性能
	private Singleton05(){
		System.out.println("Singleton05()");
	}
	//private static Singleton05 instance=new Singleton05();
	static class Inner{
		private static Singleton05 instance=
				new Singleton05();
	}
	public static Singleton05 getInstance() {
		return Inner.instance;
	}
	//public static void show() {}
}
public class TestInstanceObject04 {
	public static void main(String[] args) {
	    Thread t1=new Thread() {
	    	public void run() {
	    		Singleton05.getInstance();
	    		Singleton05.getInstance();
	    		Singleton05.getInstance();
	    	};
	    };
	    Thread t2=new Thread() {
	    	public void run() {
	    		Singleton05.getInstance();
	    		Singleton05.getInstance();
	    		Singleton05.getInstance();
	    	};
	    };
	    t1.start();
	    t2.start();
	}
}











