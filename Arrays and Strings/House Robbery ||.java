class Solution {
    public int rob(int[] a) {
        int n = a.length;
        if(n==0)
            return 0;
        if(n==1)
            return a[0];
        if(n==2)
            return Math.max(a[0],a[1]);
        int notTwo = 0;
        int Two = a[n-1];
        int notOne = a[n-2];
        int One = Math.max(a[n-1],a[n-2]);
        int maxi = Math.max(Two,Math.max(notOne,One));
        for(int i=n-3;i>=0;i--)
        {
            int notCur = Math.max(notOne,a[i] + notTwo);
            int Cur = Math.max(One,a[i] + Math.max(Two,notTwo));
            if(i>0)
                maxi = Math.max(maxi,Math.max(notCur,Cur));
            else
                maxi = Math.max(notCur,maxi);
            notTwo = notOne;
            Two = One;
            notOne = notCur;
            One = Cur;
        }

        return maxi;
    }
}
