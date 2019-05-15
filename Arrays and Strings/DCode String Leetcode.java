class Solution {
    public static int ind;
    public static int n ;
    public String util(String s)
    {
        int mult = 0;
        String ans = "";
        while(ind<n && Character.isDigit(s.charAt(ind)))
        {
            mult = (s.charAt(ind)-'0') + mult*10;
            ind ++;
        }
        if(ind<n && s.charAt(ind)=='[')
        {
            ind++;
            String returned = util(s);
            for(int i=1;i<=mult;i++)
                ans += returned;
        }
        while(ind<n && Character.isLetter(s.charAt(ind)))
        {
            ans += s.charAt(ind);
            ind ++;
        }
        if(ind<n && s.charAt(ind)==']')
        {
            ind++;
            return ans;
        }
        if(ind<n)
        {
            String returned = util(s);
            ans += returned;
        }
        return ans;
    }
    public String decodeString(String s) {
        ind =0;
        n = s.length();
        return util(s);
    }
}
