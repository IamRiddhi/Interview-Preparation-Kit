class Ans
{
  int sub;
  int odd;
}
public class Solution {
	
  	public static Ans func(BinaryTreeNode<Integer> root)
    {
      Ans ans = new Ans();
      if(root==null)
        return ans;
      Ans left = func(root.left);
      Ans right = func(root.right);
      int x = 0;
      if((root.data)%2==1)
        x = 1;
      ans.odd = left.odd + right.odd + x;
      ans.sub = left.sub+right.sub;
      int z = (left.odd+x+right.odd);
      if(z!=0 && z%2==0)
        ans.sub++;
      return ans;
    }
	public static int EvenCountOddNum(BinaryTreeNode<Integer> root)
    {
		return (func(root)).sub;
	}
}