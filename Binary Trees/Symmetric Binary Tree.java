public class Solution {
	
  	public static boolean isMirror(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2)
    {
      if(root1==null && root2==null)
        return true;
      return root1.data==root2.data && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
	public static boolean isSymmetric(BinaryTreeNode<Integer> root){
	   
      return isMirror(root,root);
		
	}
}