
public class Solution {

	/*	TreeNode structure 
	 * 
	 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

	public static int height(TreeNode<Integer> root){
	if(root==null)
      return 0;
     
     int maximum = 0;
 	for(int i=0;i<root.children.size();i++)
      maximum = Math.max(height(root.children.get(i)),maximum);
     return 1 + maximum; 
	}

}
