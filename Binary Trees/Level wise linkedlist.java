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

  /* class Node<T> {
    T data;
    Node<T> next;
    Node(T data){
      this.data = data;
    }
  }
*/
  public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root)
  {
      ArrayList<Node<BinaryTreeNode<Integer>>> ans = new ArrayList<>();
      Deque<BinaryTreeNode<Integer>> dq = new LinkedList<>();
      dq.addLast(root);
      while(!dq.isEmpty())
      {
        ArrayList<BinaryTreeNode<Integer>> levelNodes = new ArrayList<>();
        while(!dq.isEmpty())
          levelNodes.add(dq.removeFirst());

        Node<BinaryTreeNode<Integer>> head = null;
        Node<BinaryTreeNode<Integer>> itr = head;

        for(int i=0;i<levelNodes.size();i++)
        {
          BinaryTreeNode<Integer> tree = levelNodes.get(i);
          if(i==0)
          {
            head = new Node<>(tree);
            itr = head;
          }
          else
          {
            itr.next = new Node<>(tree);
            itr = itr.next;
          }
          if(tree.left!=null)
            dq.addLast(tree.left);
          if(tree.right!=null)
            dq.addLast(tree.right);
        }
        ans.add(head);
      }
      return ans;
  }


}
