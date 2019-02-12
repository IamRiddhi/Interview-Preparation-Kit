class Trie
{
    char c;
    Trie children[] = new Trie[256];
    public Trie(char ch)
    {
        c = ch;
    }
    public Trie()
    {
        
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for(int i=0;i<strs.length;i++)
        {
            String s = strs[i];
            Trie temp = root;
            if(i==0)
            {
                for(int j=0;j<s.length();j++)
                {
                    char ch = s.charAt(j);
                    temp.children[ch] = new Trie(ch);
                    temp = temp.children[ch];
                }
            }
            else
            {
                for(int j=0;j<s.length();j++)
                {
                    char ch = s.charAt(j);
                    if(temp.children[ch]==null)
                        break;
                    temp = temp.children[ch];
                } 
                for(int k=0;k<256;k++)
                    temp.children[k] = null;
            }
        }
        Trie temp = root;
        String ans = "";
        while(true)
        {
            boolean fl = false;
            for(int i=0;i<256;i++)
                if(temp.children[i]!=null) 
                {
                    temp = temp.children[i];
                    fl = true;
                    ans += temp.c;
                }
            if(!fl)
                break;
        }
        return ans;
   }
}

public class MainClass {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = stringToStringArray(line);
            
            String ret = new Solution().longestCommonPrefix(strs);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}