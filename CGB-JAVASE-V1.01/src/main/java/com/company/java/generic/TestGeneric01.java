package com.company.java.generic;
import java.util.HashMap;
/**
 * 1.class A<A,B,C,D>{}
 * 2.interface IA<K,V>{}
 * 3.List<Object> list=new ArrayList<String>();//错误
 * 4.List<String> list=new ArrayList<Object>();//错误
 * 5.List<int> list=new ArrayList<int>();//错误
 * 6.class AB extends ArrayList<E>{}//错误
 * 7.class AB<E> extends ArrayList<E>{}//正确
 * 8.class AB extends ArrayList<String>{}//正确
 * 9.class AC<V> extends HashMap<String,V>{};正确
 */
//泛型接口
interface Container<T>{
    void add(T t);
    T get(int indexs);
    int size();
}
//泛型类
abstract class AbsContainer<T> 
          implements Container<T>{
	private int size;
	public int size() {
		return size;
	}
}
class ArrayContainer<T> extends  AbsContainer<T>{
	@Override
	public void add(T t) {}
	@Override
	public T get(int indexs) {
		return null;
	}
}
class StringArrayContainer 
         extends  AbsContainer<String>{
	@Override
	public void add(String t) {}
	@Override
	public String get(int indexs) {
		return null;
	}
}
class StringMap<V> extends HashMap<String,V>{
	private static final long serialVersionUID = -7068533167649167794L;
}
public class TestGeneric01 {
   public static void main(String[] args) {
	  StringMap<Integer> map=new StringMap<>();
	  map.put("A", 100);
   }
}






