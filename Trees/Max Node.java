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
	
	
	
	public static TreeNode<Integer> maxDataNode(TreeNode<Integer> root){ 
		if(root==null)
          return null;
       TreeNode<Integer> maxNode = root;
       for(int i=0;i<root.children.size();i++)
       {
         TreeNode<Integer> temp = maxDataNode(root.children.get(i));
         if(maxNode.data<temp.data)
           maxNode = temp;
       }
      	return maxNode;

	}
		
}