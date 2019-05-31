class Pair
{
    int position;
    int value;
    public Pair(int v,int p)
    {
        position = p;
        value = v;
    }
}
class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Pair> symbols = new HashMap<>();
        symbols.put('I',new Pair(1,1));
        symbols.put('V',new Pair(5,2));
        symbols.put('X',new Pair(10,3));
        symbols.put('L',new Pair(50,4));
        symbols.put('C',new Pair(100,5));
        symbols.put('D',new Pair(500,6));
        symbols.put('M',new Pair(1000,7));
        
        int no = 0;
        int ind = 0;
        int len = s.length();
        while(ind<len)
        {
            char ch = s.charAt(ind);
            if(ind+1<len && (symbols.get(ch)).position+1==(symbols.get(s.charAt(ind+1)).position))
            {
                no += (symbols.get(ch).value*4);
                ind++;
            }
            else if(ind+1<len && ((symbols.get(ch)).position)+2==(symbols.get(s.charAt(ind+1)).position))
            {
                no += (symbols.get(ch).value*9);
                ind++;
            }
            else
                no += symbols.get(ch).value;
            ind++;
        }
        return no;
    }
}
