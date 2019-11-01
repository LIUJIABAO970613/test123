package com.company.java.generic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class ContainerUtil{
	//泛型类中的泛型不作用于静态方法
	//静态方法中使用泛型可以直接用"泛型方法"
	public static <T>void sort(List<T> list) {
		//????
	}
}
/***
    泛型通配符:  ? (实际参数)
    泛型通配符应用场景:不确定类型
  
    限定通配符：? extends,? super
    限定通配符应用场景：方法参数，方法的返回值类型
 */
class PrintUtil{
	//限定通配符:? extends 上届
	//此通配符用于限定泛型对象上届
	public static void doPrint(List<? extends CharSequence> list) {
		System.out.println(list);
	}
	//限定通配符:? super 下届
	//此通配符用于限定泛型对象下界
	public static void doPrint(Set<? super Integer> set) {
		System.out.println(set);
	} 
}
public class TestGeneric05 {
   public static void main(String[] args) {
	  Class<?> c1=ContainerUtil.class;
	  //============
	  List<String> list1=new ArrayList<String>();
	  list1.add("A");list1.add("B");
	  Set<Number> set=new HashSet<Number>();
	  set.add(100);
	  PrintUtil.doPrint(list1);
	  PrintUtil.doPrint(set);
	  
   }
}




