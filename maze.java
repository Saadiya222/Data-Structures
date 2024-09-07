package saadiya;


public class maze<T> {
	MNode<T> current,root;
	
	public maze() {
		root=current=null;
	}
	
	
	public boolean empty() {
		return root==null;
	}
	
	
	
	public boolean insert(Relative rel,T val,int k) {
		switch(rel) {
		case Root:
			if (!empty())return false;
			current=root=new MNode<T>(val,k);
			return true;
		case Parent:
			return false;
		case LeftChild:
			if(current.left!=null) return false;
			current.left=new MNode<T>(val,k);
			current=current.left;
			return true;
		case RightChild:
			if(current.right!=null) return false;
			current.right=new MNode<T>(val,k);
			current=current.right;
			return true;
		default:
			return false;
		}
	}
	
	public boolean find(Relative rel) {
		switch(rel) {
		case Root:
			current=root;
			return true;
		case Parent:
			if(current==root)return false;
			current=findparent(current,root);
			return true;
		case LeftChild:
			if(current.left==null) return false;
			current=current.left;
			return true;
		case RightChild:
			if(current.right==null) return false;
			current=current.right;
			return true;
		default:
			return false;
		}
	}
	
	private MNode<T> findparent(MNode<T> p,MNode<T> t){
		LinkedStack<MNode<T>> stack=new LinkedStack<MNode<T>>();
		MNode<T> q=t;
		while(q.right!=p&&q.left!=p) {
			if(q.right!=null)
				stack.push(p.right);
			if(q.left!=null)
				q=q.left;
			else
				q=stack.pop();
		}
		return q;
	}

	
	public boolean findnode(int k,MNode<T> root){
		
		if(root==null)
			return false;
		if(root!=null&&root.key==k) {
			current=root;
			return true;}
			return (findnode(k,root.left)||findnode(k,root.right));
		}
	
	
	
	//this method is to check if the path is valid or not in the the maze
	private boolean follow(MNode<T> t, String path) {

		int i=0;//pointer in the path
		current=t;//pointer in the binary tree
		if ((char)current.data==path.charAt(i))
			i+=2;
		else return false;
		while(i<path.length()) {
      if (current.left !=null){
			if ((char)current.left.data==path.charAt(i) ) {
				current=current.left;
				i+=2;
				continue;
			}}
         
			else if(current.right!=null) {
         if ((char)current.right.data==path.charAt(i)){
				current=current.right;
				i+=2;
				continue;
			}}
			else
				return false;}
		 return true;

		}
	
	public boolean followp(MNode<T> t, String path) {
		return follow(t, path);
	}
	
	//Check if there is a path from the node with the given key to an exit
	public boolean escape(MNode<T> t) {
	//If the given node is null then there is no path to 'X'
		if(t== null) {
			return false;
		}
	if(t.left==null && t.right==null)
		{
		//If the  node has a children ,recursively check if there is a path to 'X'
		if(t.data.equals('X'))
			return true;
		else
		    return false;
		}
		if (escape(t.left))
			return true;
		return (escape(t.right));	
	}
	
	
	     public String Short()
	    {
	        return Short_P(root);
	    }
	   
	    
	    
	    
	    private String Short_P (MNode<T> t){
	       
	        if (t==null) return null; //null node
	       
	        if (t.left == null && t.right == null && t.data.equals('X')){
	           
	            return"X";
	        }
	           
	            
	        String L=t.data+"-"+Short_P(t.left);
	        String R=t.data+"-"+Short_P(t.right);
	       
	        if(t.left==null && t.right != null) //return right
	            return R;
	        if(t.left != null && t.right == null) //return left
	            return L;
	       
	        if(t.left != null && t.right != null && L.length() <= R.length()){ //take the shorter
	            return L ;
	        }
	        else 
	            return R;
	       
	 
	        }
	
	
	
	
	
	
	
	
	
	
	
}
