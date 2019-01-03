class Ans
{
	public int maxPath;
  	public int maxSum;
}
class GfG
{
    
    public static Ans calcSum(Node root)
    {
     	Ans left = new Ans();
      	Ans right = new Ans();
      	Ans ans = new Ans();
    	if(root==null)
        	return ans;
      	left = calcSum(root.left);
      	right = calcSum(root.right);
      	ans.maxPath = root.data + Math.max(left.maxPath,right.maxPath);
        ans.maxSum = Math.max(root.data + left.maxPath + right.maxPath,
                              Math.max(left.maxSum,right.maxSum));
      	return ans;
    }
    public static int maxPathSum(Node root)
    {
        return calcSum(root).maxSum;
    }
    
    
    
}