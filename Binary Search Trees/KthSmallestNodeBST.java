public class Solution {
    public static int children(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return 0;
        return 1 + children(root.left)+ children(root.right);
    }
    public static int kthSmallestNode(BinaryTreeNode<Integer> root,int k){
		if(root==null)
            return Integer.MIN_VALUE;
        int left = children(root.left);
        if(left==k-1)
            return root.data;
        else if(left>k-1)
            return kthSmallestNode(root.left,k);
        else
            return kthSmallestNode(root.right,k-(left+1));
		
	}
}
