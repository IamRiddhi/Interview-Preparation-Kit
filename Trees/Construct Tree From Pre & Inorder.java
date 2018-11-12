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
    public static int search(int in[],int i,int j,int k)
    {
    	for(int a=i;a<=j;a++)
          if(in[a]==k)
            return a;
      	return -1;//shouldn't come here
    }
	public static BinaryTreeNode<Integer> solve(int[] pre,int[] in,int k,int i,int j)
    {
          if(i>j || i<0 || i>=pre.length || j<0 || j>=pre.length || k>=pre.length)
            return null;
		  BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(pre[k]);
          int index = search(in,i,j,pre[k]); // index in Inorder
      	  root.left = solve(pre,in,k+1,i,index-1);
      	  root.right = solve(pre,in,k+index-i+1,index+1,j);
      	  return root;
    }
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,
			int[] in)
    {
			return solve(pre,in,0,0,in.length-1);
	}

}
