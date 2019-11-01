package com.company.java.oop.instance;
import java.text.SimpleDateFormat;
import java.util.Date;
/***
 * ThreadLocal对象的作用？
 * 此对象提供了一种线程绑定机制，能够将某个对象
 * 绑定到当前线程，也可以从当前线程获取某个对象。
 * 借助此对象可以实现线程内部单例。
 */
class DateUtil{
	//SimpleDateFormat 对象线程不安全
//	private static SimpleDateFormat sdf=
//	new SimpleDateFormat("yyyy-MM-dd");
	private static ThreadLocal<SimpleDateFormat> td=
	new ThreadLocal<SimpleDateFormat>() {
		//当从当前线程获取SimpleDateFormat对象时
		//假如当前没有此对象，则调用initialValue方法
		//创建对象，并将对象绑定到当前线程。
		@Override
		protected SimpleDateFormat initialValue() {
			System.out.println("initialValue()");
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	public static String format(Date date) {
	    //从当前线程获取SimpleDateFormat 
		SimpleDateFormat sdf=td.get();
		return sdf.format(date);
	}
	public static  Date parse(String dateStr){
		try {
		return td.get().parse(dateStr);
		}catch(Exception e) {
		e.printStackTrace();
		return null;
		}
	}
}
public class TestInstanceObject06 {
    public static void main(String[] args) {
			new Thread() {
				public void run() {
					DateUtil.format(new Date());
					DateUtil.parse("2019-08-23");
				};
			}.start();
			
			new Thread() {
				public void run() {
					DateUtil.format(new Date());
					DateUtil.parse("2019-08-23");
				};
			}.start();
			new Thread() {
				public void run() {
					DateUtil.format(new Date());
					DateUtil.parse("2019-08-23");
				};
			}.start();
		
	}
}
