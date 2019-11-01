package com.company.java.enums;
enum Sex{//默认继承Enum
	MALE("男"),FEMALE("女");
	private String name;
	private Sex(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
class Member{//默认继承Object
	 Sex sex=Sex.MALE;
}
//基于枚举实现单例设计
enum Singleton{
	INSTANCE;//饿汉单例
}
public class TestEnum02 {
   public static void main(String[] args) {
	   Member m=new Member();
	   System.out.println(m.sex.getName());
	   String sexStr="MALE";
	   //将字符串转换为枚举(字符串名字必须和枚举对象名相同)
	   m.sex=Sex.valueOf(sexStr);
	   m.sex=Enum.valueOf(Sex.class, sexStr);
	   System.out.println(Sex.MALE instanceof Enum);
   }
}
