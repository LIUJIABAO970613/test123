package com.company.java.enums;
/**枚举类型*/
enum Gender{//Gender.class
	MALE,FEMALE,NONE;//对象实例(类加载时创建)
	private Gender() {//必须私有
		System.out.println("Gender()");
	}
}
/**产品对象*/
class Product{
	/**性别要求*/
	Gender gender=Gender.NONE;
}
public class TestEnum01 {
    public static void main(String[] args) {
		Product pro=new Product();
		pro.gender=Gender.FEMALE;
	}
}
