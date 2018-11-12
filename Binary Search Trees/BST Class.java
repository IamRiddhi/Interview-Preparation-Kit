/***************
 * BinaryTreeNode class already given - 
 * 
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
***************/

/**************
 * Main function that we are using internally 
 * 
public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
*******************/


/*** Cases for Delete 

let node to be deleted is k.
Case 3 : if k has both left and right children, replace root with minRight or maxLeft and delete minRight or maxLeft
which will fall under case 1 or case 2.

Case 2: if k has only one non empty child set prev's child as k's non empty child

Case 1: if k has both side null, set prev's child to be null. 

Remember if in any case, prev is null then root will be updated.

***/

public class BinarySearchTree {
	private BinaryTreeNode<Integer> root;
    
    private void print(BinaryTreeNode<Integer> root)
    {
      if(root==null)
        return;
      System.out.print(root.data+":");
      if(root.left!=null)
        System.out.print("L:"+root.left.data+",");
      if(root.right!=null)
        System.out.print("R:"+root.right.data);
       System.out.println();
       print(root.left);
       print(root.right);
    }
  
    public void printTree()
    {
    	print(root);
    }
    public void deleteData(int k)
    {
        BinaryTreeNode<Integer> node = root;
        BinaryTreeNode<Integer> prev = null;
    	while(node!=null)
        {
        	if(node.data==k)
            {
            	if(node.right!=null && node.left!=null)
                {
                	// finding out minimum of right.
                    BinaryTreeNode<Integer> minRight = node.right;
                    prev = node;
                    while(minRight.left!=null)
                    {
                     	prev = minRight;
                        minRight = minRight.left;
                    }
                    node.data = minRight.data;
                    node = minRight;
                }
               
                 if(node.right!=null)
                 {
                   if(prev==null) //deleting root;
                      root = node.right;
                   else if(prev.left!=null && prev.left.data==node.data) // node is left of prev
                     prev.left = node.right;
                   else // node is to the right of prev
                     prev.right = node.right;
                 }
                 else
                 {
                   if(prev==null)
                     root = node.left;
                   else if(prev.left!=null && prev.left.data==node.data) // node is left of prev
                     prev.left = node.left; 
                   else // node is to the right of prev
                     prev.right = node.left;
                 }
                 break;
            }
          	else if(k>node.data)
            {
              prev = node;
              node = node.right;
            }
            else
            {
              prev = node;
              node = node.left;
            }
        }
    }
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int k)
    {
    	if(root==null)
        	return new BinaryTreeNode<Integer>(k);
        if(k==root.data)
          return root;
        if(k>root.data)
          root.right = insertHelper(root.right,k);
        else
          root.left = insertHelper(root.left,k);
        return root;
    }
    public void insertData(int k)
    {
    	root = insertHelper(root,k);
    }
    private boolean searchHelper(int k,BinaryTreeNode<Integer> root)
    {
    	if(root==null)
          return false;
        if(root.data==k)
          return true;
        if(k>root.data)
        	return searchHelper(k,root.right);
        else
            return searchHelper(k,root.left);
    }
    public boolean search(int data)
    {
      return searchHelper(data,root);
    }
}
