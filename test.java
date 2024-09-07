package saadiya;
import java.util.Scanner;
public class test {
	public static void main (String[]args) {
		maze<Object> m=new maze <Object>();
		m.insert(Relative.Root,'B',0);
		m.insert(Relative.LeftChild,'S',1);
		m.insert(Relative.LeftChild,'S',2);
		m.insert(Relative.LeftChild,'S',3);
		m.find(Relative.Root);
		m.insert(Relative.RightChild,'T',4);
		m.insert(Relative.RightChild,'S',15);
		m.insert(Relative.RightChild,'S',16);
		m.insert(Relative.RightChild, 'X', 17);
		m.find(Relative.Root);
		m.find(Relative.RightChild);
		m.insert(Relative.LeftChild, 'T', 5);
		m.insert(Relative.LeftChild,'S',6);
		m.insert(Relative.LeftChild, 'S', 7);
		m.find(Relative.Root);
		m.find(Relative.RightChild);
		m.find(Relative.LeftChild);
		m.insert(Relative.RightChild, 'T', 12);
		m.insert(Relative.RightChild,'S',13);
		m.insert(Relative.LeftChild,'T',14);
		m.find(Relative.Root);
		m.find(Relative.RightChild);
		m.find(Relative.LeftChild);
		m.find(Relative.LeftChild);
		m.insert(Relative.RightChild, 'T', 8);
		m.insert(Relative.LeftChild, 'T', 9);
		m.insert(Relative.RightChild, 'T', 10);
		m.insert(Relative.RightChild,'X',11);
		
		Scanner input=new Scanner(System.in);
		int i;
		do {
			
			System.out.println("Choose the method:\n 1. follow:this method is responsible to "
					+ "check whether your path is valid or not \n 2. escape:this method is responsible "
					+ "to return true if it found an exit starting from the node that you will insert"
					+ "and return false if it didn't \n 3. Short:this method is resposible to return the shortest"
					+ "path to an exit starting from the node that you will insert\n 4. exit the program" );
			i=input.nextInt();
			switch(i) {
			case 1:
				System.out.println("Enter the key of the node");
				int k=input.nextInt();
				System.out.println("Enter the path like this way:B-S-T");
                String s=input.next();
                if(m.findnode(k,m.root))
                if(m.followp(m.current,s.toUpperCase()))
                    System.out.println("The process is done!, and the path is valid\n");
                else
                	System.out.println("The path is invalid!\n");
            break;

			case 2:
				System.out.println("Enter the key of the node");
				int n=input.nextInt();
				if(m.findnode(n,m.root))
				if(m.escape(m.current))
					System.out.println("The exit node is found!\n");
				else
					System.out.println("The exit node didn't found!\n");
				else System.out.println("The key is invalid");
	        break;
			case 3:
				System.out.println("The shorest path is "+ m.Short());
		    break;
			}
		
	}while(i!=4);
		}
	
}
