package com.company.java.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestSerializable04 {
    public static void main(String[] args)
    throws Exception{
    	   //1.构建日志对象
 	   Article a=new Article ();
 	   a.setId(100);
 	   a.setTitle("cgb");
 	   a.setContent("cgb1903");
 	   a.setCreatedTime("2019-05-28");
 	   //2.将对象序列化到文件
        ObjectOutputStream out= 
        new ObjectOutputStream( new
        FileOutputStream("f2.dat"));
        out.writeObject(a);
        out.close();
        System.out.println("序列化ok");
    //3.将对象从文件反序列化.
 	   ObjectInputStream in=new ObjectInputStream(
        new FileInputStream("f2.dat"));
 	   Object msg2=in.readObject();
 	   System.out.println(msg2);
 	   in.close();
	}
}
