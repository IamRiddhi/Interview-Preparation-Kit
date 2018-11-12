
import javafx.util.*;
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
	
  	private static Pair<TreeNode<Integer>,TreeNode<Integer>> solve(TreeNode<Integer> root)
    {
        Pair<TreeNode<Integer>,TreeNode<Integer>> maximum = null;
      
    	for(TreeNode<Integer> t: root.children)
        {
        	Pair<TreeNode<Integer>,TreeNode<Integer>> p = solve(t);
          	if(maximum==null)
              maximum = p;
          	else
            {
                TreeNode<Integer> maxNode1 = maximum.getKey();
                TreeNode<Integer> maxNode2 = maximum.getValue();
                TreeNode<Integer> pNode1 = p.getKey();
                TreeNode<Integer> pNode2 = p.getValue();
              	if(maxNode1.data==pNode1.data)
                {
                  if(pNode2!=null && maxNode2!=null && maxNode2.data<pNode2.data)
                    maxNode2 = pNode2;
                  else if(pNode2!=null && maxNode2==null)
                    maxNode2 = pNode2;
                }
            	else if(maxNode1.data<pNode1.data)
                {
                   	maxNode2 = maxNode1;
                	maxNode1 = pNode1;
                    if(pNode2!=null && maxNode2.data<pNode2.data)
                      maxNode2 = pNode2;
                }
              	else if(maxNode2==null || pNode1.data>maxNode2.data)
                  maxNode2 = pNode1;
              	maximum = new Pair<TreeNode<Integer>,TreeNode<Integer>>(maxNode1,maxNode2);
            }
        }
        // now taking root into account.
      	if(maximum==null)
        	maximum = new Pair<TreeNode<Integer>,TreeNode<Integer>>(root,null);
      	else
        {
			 TreeNode<Integer> maxNode1 = maximum.getKey();
             TreeNode<Integer> maxNode2 = maximum.getValue();
             if(root.data>maxNode1.data)
             {
               	maxNode2 = maxNode1;
             	maxNode1 = root;  
             }
          	 else if(root.data!=maxNode1.data && (maxNode2==null || root.data>maxNode2.data))
             	maxNode2 = root;
          	maximum = new Pair<TreeNode<Integer>,TreeNode<Integer>>(maxNode1,maxNode2);
        }
      	
      	return maximum;
    }
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root)
    {
   		return solve(root).getValue();
	}
	
	
}
