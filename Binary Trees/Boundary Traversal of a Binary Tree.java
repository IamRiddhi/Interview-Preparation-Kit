public class Solution {

/*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/
	public static void printLeftBoundary(BinaryTreeNode<Integer> root)
    {
    	if(root==null)
          return;
      	if(root.left!=null)
        {
          System.out.print(root.data+" ");
          printLeftBoundary(root.left);
        }  
      	else if(root.right!=null)
        {
        	System.out.print(root.data+" ");
          	printLeftBoundary(root.right); 
        }
    }
  	public static void printRightBoundary(BinaryTreeNode<Integer> root)
    {
		if(root==null)
          return;
      	if(root.right!=null)
        {
          	printRightBoundary(root.right); 
          	System.out.print(root.data+" ");
        } 
      	else if(root.left!=null)
        {
          printRightBoundary(root.left);
          System.out.print(root.data+" ");
        }  
    }
  	public static void printLeaves(BinaryTreeNode<Integer> root)
    {
      	if(root==null)
          return;
    	printLeaves(root.left);
      	if(root.left==null && root.right==null)
          System.out.print(root.data+" ");
      	printLeaves(root.right);
    }
	public static void boundaryTraversal(BinaryTreeNode<Integer> root)
    {
      	if(root!=null)
        {
          	System.out.print(root.data+" ");
			printLeftBoundary(root.left);
          	printLeaves(root.left);
          	printLeaves(root.right);
          	printRightBoundary(root.right);
        }
	}
	
}
