package com.company.java.generic;

import java.util.ArrayList;
import java.util.HashMap;

class SynchronizedList<E> extends ArrayList<E>{
	private static final long serialVersionUID = -8314872009548024015L;
	@Override
	public synchronized boolean add(E e) {
		return super.add(e);
	}
	@Override
	public synchronized E get(int index) {
		return super.get(index);
	}
}
class SynchronizedMap<K,V> extends HashMap<K, V>{
	private static final long serialVersionUID = -8969698105883977164L;
	@Override
	public synchronized V put(K key, V value) {
		return super.put(key, value);
	}
	@Override
	public synchronized V get(Object key) {
		// TODO Auto-generated method stub
		return super.get(key);
	}
}

public class TestGeneric03 {
	public static void main(String[] args) {
		
	}
}
