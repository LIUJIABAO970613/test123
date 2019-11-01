package com.company.java.serializable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public final class KryoUtil {
	  private KryoUtil() {}
	  //static Kryo kryo=new Kryo();线程不安全
	  private static ThreadLocal<Kryo> tl=
		 new ThreadLocal<Kryo>() {
		  protected Kryo initialValue() {
			  System.out.println("initialValue()");
			  Kryo kryo =new Kryo();
			  kryo.setRegistrationRequired(false);
			  return kryo;
		  };
	  };
	  /**完成对象序列化*/
      public static  byte[] serialize(Object obj)throws IOException {
    	  //1.构建Kryo对象
    	  Kryo kryo=tl.get();
    	  kryo.setRegistrationRequired(false);
    	  //2.构建流对象
    	  ByteArrayOutputStream bos=
    	  new ByteArrayOutputStream();
    	  Output output=new Output(bos);
    	  //3.对象序列化
    	  kryo.writeClassAndObject(output, obj);
    	  //4.释放资源
    	  output.close();
    	  bos.close();
    	  return bos.toByteArray();
      }
      /**完成对象的反序列化*/
      public static  Object deserialize(byte[] array) {
    	  //1.构建Kryo对象
    	  Kryo kryo=tl.get();
    	  //2.构建输入流对象
    	  Input input=new Input(
    	  new ByteArrayInputStream(array));
    	  //3.对象的反序列化
    	  Object obj=kryo.readClassAndObject(input);
    	  //4.释放资源
    	  input.close();
    	  return obj;
      }
}
