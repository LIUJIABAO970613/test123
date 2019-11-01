package com.company.java.generic;
import java.util.LinkedList;
/**泛型类*/
class Stack<E>{
	private LinkedList<E> stack=new LinkedList<E>();
	//入栈
	public void push(E e) {
		stack.addFirst(e);
	}
	//出栈
	public E pop() {
		return stack.pop();
	}
}
public class TestGenericHomework01 {
    public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(100);
		s.push(200);
		s.push(300);
		Integer e=s.pop();
		System.out.println(e);
		e=s.pop();
		System.out.println(e);
		
	}
}
