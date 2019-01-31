import java.util.*;
public class Solution {

	public static boolean check_Postorder_Sequence(int []post, int n)
    {
    	ArrayDeque<Integer> stack = new ArrayDeque<>();
      	int root = Integer.MAX_VALUE;
      	for(int i=n-1;i>=0;i--)
        {
        	if(post[i]>root) //left element cannot be greater than root.
              return false;
          	while(stack.size()>0 && post[i]<stack.getFirst())
            {
              root = stack.getFirst();
              stack.removeFirst();
            }
          	stack.addFirst(post[i]);  
        }
      	return true;
	}
}
