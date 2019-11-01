package com.company.java.oop.abs;

abstract class AbsClassA{
	public void doMethod01() {}
	public abstract void doMethod02();
} 
class ClassAA extends AbsClassA{
	@Override
	public void doMethod02() {
	}
}
public class TestAbstract01 {
   public static void main(String[] args) {
	   AbsClassA a=new ClassAA();
	   AbsClassA b=new AbsClassA() {
		   @Override
		  public void doMethod02() {
			
		  }
	   };
   }
}
