class Solution {
    public void swap(int nums[],int x,int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void doPermute(int[] nums,int l,List<List<Integer>> ans)
    {
        if(l==nums.length-1)
        {
            List<Integer> x = new ArrayList<>();
            for(int y:nums)
                x.add(y);
            ans.add(x);
            return;
        }
        for(int i=l;i<nums.length;i++)
        {
            swap(nums,i,l);
            doPermute(nums,l+1,ans);
            swap(nums,i,l);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        doPermute(nums,0,ans);   
        return ans;
    }
}