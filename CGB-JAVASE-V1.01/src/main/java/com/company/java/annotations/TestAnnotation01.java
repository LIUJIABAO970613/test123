package com.company.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity{
}
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@interface ID{
}
/**栏目对象*/
@Entity
class Column{
	@ID
	private int id;
}
public class TestAnnotation01 {
    public static void main(String[] args)
    throws Exception{
		//1.获取Column字节码对象
    	Class<?> c1=Column.class;
    	//2.获取类上注解
    	Entity entity=
    	c1.getDeclaredAnnotation(Entity.class);
    	System.out.println(entity);
    	//3.获取属性id上的ID注解
    	Field f=c1.getDeclaredField("id");
    	ID id=
    	f.getDeclaredAnnotation(ID.class);
    	System.out.println(id);
	}
}





