import java.util.ArrayList;
import java.util.*; 

public class Solution {

  /*  Binary Tree Node class
   * 
   * class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
      this.data = data;
    }
  }
   */
    private static HashMap<Integer,ArrayList<Integer>> orders = new HashMap<>();
  private static void traverse(BinaryTreeNode<Integer> root,int order)
    {
      if(root==null)
        return;
      if(orders.containsKey(order))
        orders.get(order).add(root.data);
      else
      {
        orders.put(order,new ArrayList<Integer>());
        orders.get(order).add(root.data);
      }
      traverse(root.left,order-1);
      traverse(root.right,order+1);
    }
  public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root){
        
    traverse(root,0);
        Set<Map.Entry<Integer,ArrayList<Integer>>> s = orders.entrySet();
        for(Map.Entry<Integer,ArrayList<Integer>> e:s)
        {
          for(int x:e.getValue())
            System.out.print(x+" ");
          System.out.println();
        }
  }



}