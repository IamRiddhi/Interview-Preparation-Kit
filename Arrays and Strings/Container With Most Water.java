class Solution {
    public int maxArea(int[] height) {
     int maxarea = 0;
      int l = 0;
        int r = height.length-1;
        while(l<=r)
        {
            maxarea = Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
