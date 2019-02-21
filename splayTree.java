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

    Node getActualRoot(){
        return root;
    }

    void add(int value){
        array.add(value);
    }

    int maxDepth(Node node){ 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left); 
            int rDepth = maxDepth(node.right); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
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
    
    void run(){
        int numValue = 0;
        for(int i = 0; i< 100 ;i++){
            numValue = (int)(Math.random()*99) + 10;
            insert(numValue);
            add(numValue);
            splay(numValue);
            System.out.println("Max height is " + maxDepth( getActualRoot() ));


        }
    }

	// Driver Program to test above functions 
	public static void main(String[] args) { 
        splayTree tree = new splayTree();
        tree.run();
	} 
} 
