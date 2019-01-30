import java.util.*;
public class Solution {
	public static BinaryTreeNode<Integer> prev,cur;
  	public static ArrayList<Integer> ans;
  	public static void Helper(BinaryTreeNode<Integer> root)
    {
      	if(root==null)
          return;
      	Helper(root.left);
    	cur = root;
      	if(prev!=null && prev.data>cur.data)
        {
          if(ans.size()==0)
          {
            ans.add(cur.data);
            ans.add(prev.data);
          }
          else
          {
            ans.remove(0);
            ans.add(0,cur.data);
          }
        }
        prev = cur;
        Helper(root.right);
    }
    public static ArrayList<Integer> recoverBST(BinaryTreeNode<Integer> root)
    {
      	ans = new ArrayList<>();
    	Helper(root);
      	return ans;
      	
	}
}