class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = 0;
        if(r>0)
            c = matrix[0].length;
        int lo = 0;
        int hi = r * c - 1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            int k = matrix[mid/c][mid%c];
            if(k==target)
                return true;
            else if (target>k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }
}
