package com.company.java.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**频道对象*/
class Channel implements Serializable{
	private static final long serialVersionUID = -5996516514113734906L;
	private int id;
	private String name;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", state=" + state + "]";
	}
	
}
//基于Kryo序列化框架完成对象的序列化操作
//最大优势：速度比较快
public class TestSerializable05 {
	
	public static void main(String[] args)
	throws Exception{
		//构建频道对象
		Channel channel=new Channel();
		channel.setId(100);
		channel.setName("教育");
		channel.setState(1);
		//实现对象序列化和反序列化
		//quickStart(channel);
		
		byte[] array=KryoUtil.serialize(channel);
		Object obj=KryoUtil.deserialize(array);
		System.out.println(obj);
	}

	private static void quickStart(Channel channel) throws FileNotFoundException {
		//对象序列化
		Kryo kryo = new Kryo();
		kryo.register(Channel.class);
		Output output = new Output(
		new FileOutputStream("file.bin"));
		kryo.writeObject(output,channel);
		output.close();
        //对象的反序列化
		Input input = new Input(
		new FileInputStream("file.bin"));
		Channel object2 = 
		kryo.readObject(input, Channel.class);
		System.out.println(object2);
		input.close();
	}
}








