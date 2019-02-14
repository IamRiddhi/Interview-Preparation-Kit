class Solution {
    public String convert(String s, int r) {
        String res = "";
        if(r==1 || r>=s.length())
        {
           res = s;
           return res;
        }
        for(int i=0;i<r;i++)
            if(i==0)
            {
                int k = i;
                while(k<s.length())
                {
                    res += s.charAt(k);
                    k = k + (r-i-1) + (r-i-2) + 1;
                }
            }
            else if(i==r-1)
            {
                int k = i;
                while(k<s.length())
                {
                    res += s.charAt(k);
                    k = k + (r-1) + (r-2) + 1;
                }
            }
            else
            {
                int cnt = 0;
                int k = i;
                while(k<s.length())
                {
                    res += s.charAt(k);
                    if(cnt%2==0)
                        k = k + (r-i-1) + (r-i-2) + 1;
                    else
                        k = k + 2*i;
                    cnt++;
                }
            }
        return res;
    }
}
