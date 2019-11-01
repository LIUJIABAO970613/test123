package com.company.java.oop.instance;
class Looper{
	public Looper() {
		System.out.println("Looper()");
	}
}
class LooperUtil{
	private static ThreadLocal<Looper> tl=new ThreadLocal<Looper>();
	public static Looper getLooper() {
		Looper looper=tl.get();
		if(looper==null) {
			looper=new Looper();
			tl.set(looper);
		}
		return looper;
	}
}
public class TestInstanceObject07 {
    public static void main(String[] args) {
		LooperUtil.getLooper();
		LooperUtil.getLooper();
		LooperUtil.getLooper();
		new Thread() {
			public void run() {
				LooperUtil.getLooper();
			};
		}.start();
	}
	
}
