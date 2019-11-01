package com.company.java.oop.cls;

import java.util.HashMap;
import java.util.Map;
class ClassE{
	static ClassE instance=new ClassE();
	static Map<String,Object> map=
			new HashMap<>();
	public ClassE() {
		map.put("A", 100);
		map.put("B",200);
	}
}
public class TestClassObject08 {
	public static void main(String[] args) {
		System.out.println(ClassE.map);
	}
}
