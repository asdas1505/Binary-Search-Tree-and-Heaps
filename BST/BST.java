//package col106.assignment3.BST;
import java.util.LinkedList; 
import java.util.Queue; 

public class BST<T extends Comparable, E extends Comparable> implements BSTInterface<T, E>  {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
//	public static void main() {
//		BSTDriverCode BDC = new BSTDriverCode();
//		System.setOut(BDC.fileout());
//	}
	/*
	 * end code
	 * start writing your code from here
	 */

	public static void main(String[] args) {
        BST<Integer, Integer> obj = new BST<Integer, Integer>();
        obj.insert (1,15);
        obj.insert (2, 5);
        obj.insert (3,1);
        obj.insert (4, 6);
        obj.insert (5, 20);
        obj.insert (6, 16);
        obj.insert (7, 25);
        obj.insert (8, 21);
        obj.insert (9, 26);
        obj.printBST();
        System.out.println("wtf");
        obj.delete (3);
        obj.printBST();
        System.out.println("wtf");
        obj.update (9,300);
        obj.printBST();
    }

	public class Node{
		T key;
		E value;
		Node right;
		Node left;

		public Node(T key, E value){
			right = null;
			left = null;
			this.key = key;
			this.value = value;
		}
	}

	public Node root;	
	public static int flag = 0;

	//write your code here 
	@SuppressWarnings("unchecked")	
	private Node insertTemp(Node temp, T key, E value){
		if(temp.value.compareTo(value)==1){
			if(temp.left==null){
				flag = 1;
				return temp;	
			}
			else{
				temp = temp.left;
				return insertTemp(temp, key, value);	
			}
		}
		else{
			if(temp.right==null){
				flag = 0;
				return temp;
			}
			else{
				temp = temp.right;
			+	return insertTemp(temp, key, value);
			}
		}			
	}	

    public void insert(T key, E value) {
		//write your code here
    	if(root==null){
    		root = new Node(key,value);
    	}		
    	else{
    		Node k = new Node(key,value);
    		Node p = insertTemp(root, key, value);		
    		if(flag == 1){
    			p.left = k;
    		}
    		else{
    			p.right = k;
    		} 	
    	}

    }

    @SuppressWarnings("unchecked")	
    public void update(T key, E value) {
		//write your code here
	    delete(key);
	    System.out.println("sad");
	    insert(key,value);  		
    }

	@SuppressWarnings("unchecked")
    public void delete(T key) {
		
    	Node temp = findNode(key);	

    	if(temp.left!=null && temp.right!=null){
    		Node temp1 = temp;
    		temp = temp.right;
    		while(temp.left!=null){
    			temp = temp.left;
    		}

    		T k = temp.key;
    		E v = temp.value;
    		delete(k);
    		temp1.key = k;
    		temp1.value = v;

    		/*
			Node temp2 = findParent(temp.key);
    		temp1.value = temp.value;
    		temp1.key = temp.key;*/

    		/*if(temp.right!=null){
    			temp2.left = temp.right;
    		}
    		else{
    			temp2.left = null;	
    		}*/
    	
    	}

    	else if(temp.left!=null && temp.right==null){
    		Node tempP = findParent(key);
    		tempP.left = temp.left;
    	}
    	else if(temp.left==null && temp.right!=null){
    		Node tempP = findParent(key);
    		tempP.right = temp.right;
    	}
    	else if (temp.left==null&& temp.right==null){
    		Node tempP = findParent(key);
    		if(tempP.left!=null && tempP.left.key.compareTo(temp.key)==0){
    			tempP.left = null;
    		}
    		else if (tempP.right!=null &&tempP.right.key.compareTo(temp.key)==0){
    			tempP.right = null;
    		}
    	}
    }

    @SuppressWarnings("unchecked")
    public Node findNode(T key){

    	Queue<Node> q = new LinkedList<>(); 
    	q.add(root);
    	Node temp = null;
    	while(q.size()!=0){
    		temp = q.remove();
    		if(temp.key.compareTo(key)==0){
    			break;	
    		}

    		if(temp.left!=null){
    			q.add(temp.left);		
    		}
    		if(temp.right!=null){
    			q.add(temp.right);
    		}	
    	}

    	return temp;
    }

    @SuppressWarnings("unchecked")
    public Node findParent(T key){

    	Queue<Node> q = new LinkedList<>(); 
    	q.add(root);
    	Node temp = null;
    	while(q.size()!=0){
    		temp = q.remove();
    		if(temp.left!=null){
    			if(temp.left.key.compareTo(key)==0){
    				break;
    			}	
    		}
    		if(temp.right!=null){
    			if(temp.right.key.compareTo(key)==0){
    				break;
    			}
    		}
    		if(temp.left!=null){
    			q.add(temp.left);		
    		}
    		if(temp.right!=null){
    			q.add(temp.right);
    		}	
    	}
    	return temp;
    }

    public void printBST () {
		//write your code here	
    	Queue<Node> q = new LinkedList<>(); 
    	q.add(root);
    	while(q.size()!=0){
    		Node temp = q.remove();
    		System.out.println(temp.key + " " + temp.value);
    		if(temp.left!=null){
    			q.add(temp.left);		
    		}
    		if(temp.right!=null){
    			q.add(temp.right);
    		}	
    	}
    }

}