class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k)
    {
       int ans = 0;
       if(k<=1) return ans;
        int lo = 0;
        int hi = 0;
        long pro = 1;
        while(hi < nums.length)
        {
            pro *= nums[hi];
            while(lo <= hi && pro >= k)
            {
                pro /=  nums[lo];
                lo++;
            }
            hi++;
            ans += (hi-lo); 
        }
        return ans;
    }
}
