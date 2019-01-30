
// Following is the Binary Tree node structure
/**************
class BinaryTreeNode {
    public : 
    T data;
    BinaryTreeNode<T> *left;
    BinaryTreeNode<T> *right;

    BinaryTreeNode(T data) {
        this -> data = data;
        left = NULL;
        right = NULL;
    }
};
***************/

public class Solution {

	public static BinaryTreeNode<Integer> remove_Outside_Range(BinaryTreeNode<Integer> root, int min, int max)
    {
		if(root==null)
          return null;
      	root.left = remove_Outside_Range(root.left,min,max);
      	root.right = remove_Outside_Range(root.right,min,max);
      	if(root.data<min)
          return root.right;
      	if(root.data>max)
          return root.left;
      	return root;
	}
}
