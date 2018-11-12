public class Solution {

/*	Binary Tree Node class 
 * 
 * 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/
	
	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
		
      if(root==null)
        return;
      if(k1<root.data)
        printNodeFromK1ToK2(root.left,k1,k2);
      if(root.data>=k1 && root.data<=k2)
       	 System.out.print(root.data+" ");
      if(k2>root.data)
        printNodeFromK1ToK2(root.right,k1,k2);
	}
	
	
}
