class Solution {
    public boolean circularArrayLoop(int[] a)
    {
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]<=1000)
            {
                int start = 1001 + i;
                int cur = start;
                int cur_dir = 1;
                if(a[start-1001]<0)
                    cur_dir = -1;
                while(true)
                {
                    if(a[cur-1001]>1000 && cur!=start)
                        break;
                    if(a[cur-1001]%n==0)
                    {
                        a[cur-1001] = start;
                        break;
                    }
                    int next = (a[cur-1001]+(cur-1001))%n;
                    if(next<0)
                        next = (next+n)%n;
                    if(a[next]==start)
                        return true;
                    int next_dir = 1;
                    if(a[next]<0)
                        next_dir = -1;
                    if(cur_dir!=next_dir)
                    {
                        a[cur-1001] = start;
                        break;
                    }
                    a[cur-1001] = start;
                    cur = next + 1001;
                    cur_dir = next_dir;
                }
            }
        }
        return false;
                
    }
}
