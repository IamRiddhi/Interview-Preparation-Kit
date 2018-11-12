import java.util.*;
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
	
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root)
    {
    	TreeNode<Integer> tnode = null;
        int maxSum = 0;
      	int sum = 0;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
      	while(q.size()>0)
        {
        	TreeNode<Integer> t = q.remove();
          	sum = t.data;
            for(TreeNode<Integer> x : t.children)
            {
            	sum += x.data;
                q.add(x);
            }
            if(maxSum<sum)
            {
              maxSum = sum;
              tnode = t;
            }
        }
        return tnode;
	}
}
