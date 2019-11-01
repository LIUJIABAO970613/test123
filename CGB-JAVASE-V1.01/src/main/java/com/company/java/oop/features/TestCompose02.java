package com.company.java.oop.features;
interface MailService{
	void send(String msg);
}
final class DefaultMailService implements MailService{
	@Override
	public void send(String msg) {
		System.out.println("send "+msg);
	}
}
class LogMailService{
	//has a (组合)
	private MailService mailService;
	public LogMailService(MailService mailService) {
		this.mailService=mailService;
	}
	public void send(String msg) {
		System.out.println("start:"+System.nanoTime());
	    this.mailService.send(msg);	
	    System.out.println("send:"+System.nanoTime());
	}
}
public class TestCompose02 {
	public static void main(String[] args) {
		LogMailService logService=
		new LogMailService(new DefaultMailService());
		logService.send("祝贺CGB1906所有同学高薪就业");
	}
}
