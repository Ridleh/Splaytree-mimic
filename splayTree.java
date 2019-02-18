import java.lang.reflect.Array;
import java.util.ArrayList;

//java code to mimic splaying of a tree
class splayTree { 
    ArrayList<Integer> array = new ArrayList<Integer>();

	// node class
	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

	// Constructor 
	splayTree() { 
		root = null; 
	} 

	// This method mainly calls insertRec() 
	void insert(int key) { 
	root = insertRec(root, key); 
	} 
	
	//inserting a node recursively 
	Node insertRec(Node root, int key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
    } 
    
    Node splay(int key){
        root = new Node(key);
        splayInsert();
        return root;
        
    }

    void splayInsert(){
        for(int i = array.size()-1; i > 0; i--){
            insert(array.get(i));
        }
    }

    int getRoot(){
        return root.key;
    }

    void add(int value){
        array.add(value);
    }

	// This method mainly calls InorderRec() 
	void inorder() { 
	inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 

	// Driver Program to test above functions 
	public static void main(String[] args) { 
        splayTree tree = new splayTree(); 

        tree.insert(50); 
        tree.add(50);

        tree.insert(30);
        tree.add(30);
        tree.splay(30);

        tree.insert(20);
        tree.add(20);
        tree.splay(20);
        
        tree.insert(40);
        tree.add(40);
        tree.splay(40);
        
        tree.insert(70);
        tree.add(70);
        tree.splay(70);
        
        tree.insert(60);
        tree.add(60);
        tree.splay(60);
        
        tree.insert(80);
        tree.add(80);
        tree.splay(80); 

		// print inorder traversal of the BST 
        tree.inorder(); 
        System.out.println("root of tree is: " + tree.getRoot());
	} 
} 
