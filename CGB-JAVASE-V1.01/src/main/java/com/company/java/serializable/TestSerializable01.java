package com.company.java.serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
class Message implements Serializable{
	private static final long serialVersionUID = 3457313395785928165L;
	private int id;
	private String content;
	private Date createdTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}
}
public class TestSerializable01 {
    public static void main(String[] args)throws Exception {
		//构建一个对象
    	Message msg1=new Message();
		msg1.setId(100);
		msg1.setContent("cgb1906");
		//将对象序列化到文件
//		ObjectOutputStream oos=
//		new ObjectOutputStream(
//		new FileOutputStream("f1.txt"));
//		oos.writeObject(msg1);
//		oos.close();
//		System.out.println("序列化OK");
		//将对象反序列化
		ObjectInputStream ois=
		new ObjectInputStream(
	    new FileInputStream("f1.txt"));
		Object obj=ois.readObject();
		ois.close();
		System.out.println("反序列化OK");
		System.out.println(obj);
		System.out.println(msg1==obj);
		System.out.println(msg1.equals(obj));
	}
}










