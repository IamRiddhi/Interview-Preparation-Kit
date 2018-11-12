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

	public static void printLevelWise(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        q.add(root);
        while(q.size()>0)
        {
          TreeNode<Integer> node= q.peek(); q.remove();
          System.out.print(node.data+":");
          for(int i=0;i<node.children.size();i++)
          {
            if(i==node.children.size()-1)
              System.out.print(node.children.get(i).data);
            else
              System.out.print(node.children.get(i).data+",");
            q.add(node.children.get(i));
          }
          System.out.println();
        }
	}

}
