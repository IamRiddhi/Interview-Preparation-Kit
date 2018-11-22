import java.util.ArrayList;

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
	
  public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root)
  {
  	if(root==null)
      return new ArrayList<Integer>();
    ArrayList<Integer> leftPath = longestRootToLeafPath(root.left);
    ArrayList<Integer> rightPath = longestRootToLeafPath(root.right);
    if(leftPath.size()>rightPath.size())
    {
      leftPath.add(root.data);
      return leftPath;
    }
    else
    {
      rightPath.add(root.data);
      return rightPath;
    }
  }
	
}