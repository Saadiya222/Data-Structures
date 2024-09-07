package saadiya;

public class LinkedStack<T> {
	private Node<T> top;
	
	public LinkedStack() {
		top=null;
	}
	
	public boolean empty() {
		return top==null;
	}
	
	public boolean full() {
		return false;
	}
	
	public void push(T e) {
		Node<T> tmp=new Node<T>(e);
		tmp.next=top;
		top=tmp;
	}
	
	public void push(Node<T> e) {
		Node<T> tmp=e;
		tmp.next=top;
		top=tmp;
	}
	
	public T pop() {
		T e=top.data;
		top=top.next;
		return e;
	}

}
