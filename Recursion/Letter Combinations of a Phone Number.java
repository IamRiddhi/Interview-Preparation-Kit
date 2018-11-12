import java.util.Collections; 
class Solution {
    private void solve(ArrayList<String> chars,int i,ArrayList<String> out,String s) 
    {
        if(i==chars.size())
        {
            out.add(s);
            return;
        }
        int len = chars.get(i).length();
        for(int j=0;j<len;j++)
            solve(chars,i+1,out,s+chars.get(i).charAt(j)+"");
    }
    public int binarySearch(int a[],int k)
    {
        if(k==2) return 2;
        if(k==3) return 5;
        if(k==4) return 8;
        if(k==5) return 11;
        if(k==6) return 14;
        if(k==7) return 18;
        if(k==8) return 21;
        if(k==9) return 25;
        
        return -1;
    }
    public List<String> letterCombinations(String digits) {
        int p[] = new int[26];
        p[0] = p[1] = p[2] = 2;
        p[3] = p[4] = p[5] = 3;
        p[6] = p[7] = p[8] = 4;
        p[9] = p[10] = p[11] = 5;
        p[12] = p[13] = p[14] = 6;
        p[15] = p[16] = p[17] = p[18] = 7;
        p[19] = p[20] = p[21] = 8;
        p[22] = p[23] = p[24] = p[25] = 9;
        
        ArrayList<String> chars = new ArrayList<>();
        for(int i=0;i<digits.length();i++)
        {
            String s = ""; 
            int d = Integer.parseInt(digits.charAt(i)+"");
            int keyno = binarySearch(p,d);
            int lower = binarySearch(p,d-1);

            for(int j=lower+1;j<=keyno;j++)
            {
                char a = (char)('a' + j);
                s += (a + "");
            }
            chars.add(s);
        }
   
        ArrayList<String> out = new ArrayList<>();
        if(chars.size()==0)
            return out;
        solve(chars,0,out,"");
        return out;
    }
}