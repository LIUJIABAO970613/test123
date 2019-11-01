package com.company.java.oop.abs;
interface IC{
	void a();
	void b();
	void c();
}
//适配器模式
abstract class AbsClassC implements IC{
	@Override
	public void a() {
	}
	@Override
	public void b() {
	}
	@Override
	public void c() {
	}
}
class ClassC extends AbsClassC{
	@Override
	public void a() {
	   System.out.println("ClassC.a()");
	}
}
public class TestInterfaceAbstract01 {

}
