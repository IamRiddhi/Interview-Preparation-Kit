
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
	public static int minimum;
    public static TreeNode<Integer> tnode;
    public static void solve(TreeNode<Integer> root, int n)
    {
		if(root.data>n)      
        { 
          if(minimum==Integer.MIN_VALUE)
          {
	          minimum = root.data;
	          tnode = new TreeNode<Integer>(root.data);
          }
          else if(minimum>root.data)
          {
            tnode = root;
            minimum = root.data;
          }
        }
        for(TreeNode<Integer> t: root.children)
         	solve(t,n);
          
    }
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n)
    {
		minimum = Integer.MIN_VALUE;
        solve(root,n);
      	return tnode;
	}
	
}
