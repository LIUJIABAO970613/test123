package com.company.java.serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
class Replay implements Serializable{
	private static final long serialVersionUID = 4402236232504078743L;
	/**transient 关键在描述的属性不进行序列化*/
	private transient int id;
	private String content;
	/**当我们调用对象流的writeObject方法时，系统
	 * 底层会调用此类中的writeObject方法，
	 * 但此方法的格式必须这样设计(例如方法私有)*/
	private void writeObject(ObjectOutputStream out)
	throws IOException{
		//1.对数据加密
		//2.1获取加密对象
		Encoder en=Base64.getEncoder();
		//2.2执行加密操作
		byte[] encodeBytes=en.encode(content.getBytes());
		content=new String(encodeBytes);
		//2.对数据进行默认序列化
		out.defaultWriteObject();
	}
	/**当我们调用对象流的readObject方法时，系统
	 * 底层会调用此类中的readObject方法，
	 * 但此方法的格式必须这样设计(例如方法私有)*/
	private void readObject(ObjectInputStream in)
			throws Exception{
		//1.对内容进行反序列化
		in.defaultReadObject();
		//2.对内容进行解密操作
		//2.1获取解密对象
		Decoder decoder=Base64.getDecoder();
		//2.2执行解密操作
		byte[] decoderBytes=
		decoder.decode(content.getBytes());
		content=new String(decoderBytes);
	}
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
		return "Replay [id=" + id + ", content=" + content + "]";
	}
}
public class TestSerializable03 {
    static void server()throws Exception {//服务端
      //1.构建server对象，并在9999端口进行监听
      ServerSocket server=new ServerSocket(9999);
      //2.等待客户端的连接
      Socket socket=server.accept();//阻塞式方法
      System.out.println("客户端已连接");
      //3.获取对象流输入对象
      ObjectInputStream ois=
      new ObjectInputStream(socket.getInputStream());
      //4.读取流中对象
      Object object=ois.readObject();
      System.out.println(object);
      //5.释放资源
      ois.close();
      socket.close();
      server.close();
    }
    static void client()throws Exception {//客户端
      //1.构建客户端对象
      Socket socket=new Socket("127.0.0.1", 9999);
      //2.获取输出流对象
      ObjectOutputStream ois=
      new ObjectOutputStream(socket.getOutputStream());
      //3.写对象到服务端
      Replay replay=new Replay();
      replay.setId(200);
      replay.setContent("helloworld");
      ois.writeObject(replay);
      //4.释放资源
      ois.close();
      socket.close();
    }
	public static void main(String[] args)throws Exception {
		new Thread() {
			@Override
			public void run() {
				try {
				server();
				}catch(Exception e) {e.printStackTrace();}
			}
		}.start();
		
		client();
	}
}










