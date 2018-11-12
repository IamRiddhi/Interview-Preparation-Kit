public class Solution {

	public static boolean isBST(BinaryTreeNode<Integer> root,int min,int max)
    {
		if(root==null)
          return true;
      	if(root.data<min || root.data>max)
          return false;
       boolean isLeftOK = isBST(root.left,min,root.data-1);
       boolean isRightOK = isBST(root.right,root.data,max);
       return isLeftOK && isRightOK;
	}
  	public static boolean isBST(BinaryTreeNode<Integer> root)
    {
      return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}