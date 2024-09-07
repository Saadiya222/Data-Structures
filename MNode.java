package saadiya;

public class MNode<T> {
	public int key;
	public T data;
	public MNode <T> left,right;
	public MNode <T> next;
	
	
	public MNode(T val,int k) {
		key=k;
		data=val;
		left=right=null;
	}
	
	public MNode( T val,int k, MNode<T> l,MNode<T>r) {
		key=k;
		data=val;
		left=l;
		right=r;
	}
}
