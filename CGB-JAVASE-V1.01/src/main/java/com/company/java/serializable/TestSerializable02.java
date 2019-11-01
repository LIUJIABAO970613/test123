package com.company.java.serializable;
import java.io.Serializable;
import com.company.java.cache.PerpetualCache;
import com.company.java.cache.SerializedCache;
//问题对象
class Problem implements Serializable{
	private static final long serialVersionUID = 1089513728303620871L;
	private Integer id;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + "]";
	}
}
public class TestSerializable02 {
	public static void main(String[] args) {
		Problem p=new Problem();
		p.setId(100);
		p.setTitle("序列化cache如何实现");
		//构建cache对象
		SerializedCache cache=
		new SerializedCache(new PerpetualCache());
		//对象序列化
		cache.putObject("pKey", p);
		//对象反序列化
		Object obj1=cache.getObject("pKey");
		System.out.println(obj1);
		Object obj2=cache.getObject("pKey");
		System.out.println(obj1==p);
		System.out.println(obj1==obj2);
	}
}









