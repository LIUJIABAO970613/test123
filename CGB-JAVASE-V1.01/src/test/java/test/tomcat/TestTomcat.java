package test.tomcat;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;
public class TestTomcat {
	//内嵌tomcat的启动测试
	@Test
	public void testTomcat()throws Exception {
		//1.创建tomcat对象
		Tomcat t=new Tomcat();
		//2.创建Connector对象
		Connector c=new Connector("HTTP/1.1");
		//3.设置Connector对象]
		c.setPort(8080);
		t.getService().addConnector(c);
		//4.启动tomcat对象
		t.start();
		//5.阻塞当前线程
		t.getServer().await();
	}
	@Test
	public void testServlet()throws Exception {
		//1.创建tomcat对象
		Tomcat t=new Tomcat();
		//2.创建Connector对象
		Connector c=new Connector("HTTP/1.1");
		//3.设置Connector对象]
		c.setPort(8080);
		t.getService().addConnector(c);
		//4.配置servlet对象
		//4.1构建Context对象，并设置path为"/"
		Context ctx=t.addContext("/",null);
		//4.2注册servlet
		Tomcat.addServlet(
				ctx,
		"helloServlet", 
		"com.company.java.servlet.HelloServlet");
		//4.3设置servlet映射路径
		ctx.addServletMappingDecoded("/hello",
				"helloServlet");
		//5.启动tomcat对象
		t.start();
		//6.阻塞当前线程
		t.getServer().await();
	}
}
