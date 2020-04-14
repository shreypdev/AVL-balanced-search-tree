public class AVL_BST{
	public static boolean checkAVL(BST b){
		return(b.isBalanced());
	}
	
	public static BST createBST(int[] a){
		BST tree = new BST();
		for (int i = 0; i < a.length; i++){
			tree.insert(a[i]);
		}
		return tree;
	}
	public static void main(String[] args){
		int[] A = {1,2,0,4,-1};
		BST b = createBST(A);
		System.out.println(checkAVL(b));
	}
}

class BST{
	public static  Node root;
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public boolean isBalanced(){
		return(isBalanced(this.root));
	}
	private boolean isBalanced(Node root){
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */
 
        if (root == null)
            return true;
 
        lh = height(root.left);
        rh = height(root.right);
 
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left)
                && isBalanced(root.right))
            return true;
 
        return false;
    }
 
    public static int max(int a, int b){
        return (a >= b) ? a : b;
    }
 
    public static int height(Node root){
        if (root == null)
            return 0;
 
        return 1 + max(height(root.left), height(root.right));
    }
}

class Node{
	int data;
	Node left;
	Node right;

	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}

}