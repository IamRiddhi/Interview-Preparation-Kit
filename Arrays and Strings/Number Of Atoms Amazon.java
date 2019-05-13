import java.util.*;
class Solution {
    public static int ind = 0;
    public static int n ;
    public TreeMap<String,Integer> util(String s)
    {
        TreeMap<String,Integer> hmap = new TreeMap<>();
        if(ind>=n) return hmap;
        while(ind<n && Character.isLetter(s.charAt(ind)))
        {
            String atom = "";
            atom += s.charAt(ind);
            ind++;
            while(ind<n && s.charAt(ind)>='a' && s.charAt(ind)<='z')
            {
                atom += s.charAt(ind);
                ind++;
            }
            int mult = 1;
            int x = 0;
            while(ind<n && Character.isDigit(s.charAt(ind)))
            {
                x = (s.charAt(ind) - '0') + x*10;
                ind++;
            }
            mult = Math.max(mult,x);
            if(hmap.get(atom)==null)
                hmap.put(atom,mult);
            else
                hmap.put(atom,mult+hmap.get(atom));
        }
        if(ind<n && s.charAt(ind)=='(')
        {
            ind++;
            TreeMap<String,Integer> returned = util(s);
            int mult = 1;
            int x = 0;
            while(ind<n && Character.isDigit(s.charAt(ind)))
            {
                x = (s.charAt(ind) - '0') + x*10;
                ind++;
            }
            mult = Math.max(mult,x);
            Set<Map.Entry<String,Integer>> st = returned.entrySet();
            for(Map.Entry<String,Integer> m:st)
            {
                String k = m.getKey();
                int v = m.getValue();
                if(hmap.get(k)==null)
                    hmap.put(k,v*mult);
                else
                    hmap.put(k,hmap.get(k)+v*mult);
            }
        }
        if(ind<n && s.charAt(ind)==')')
        {
            ind++;
            return hmap;
        }    
        if(ind<n)
        {
            TreeMap<String,Integer> returned = util(s);
            Set<Map.Entry<String,Integer>> st = returned.entrySet();
            for(Map.Entry<String,Integer> m:st)
            {
                String x = m.getKey();
                int val = m.getValue();
                if(hmap.get(x)==null)
                    hmap.put(x,val);
                else
                    hmap.put(x,hmap.get(x)+val);
            }
        }
        return hmap;
            
    }
    public String countOfAtoms(String formula) {
        ind = 0;
        n = formula.length();
        String a = "";
        TreeMap<String,Integer> hmap = util(formula);   
        Set<Map.Entry<String,Integer>> s = hmap.entrySet();
        for(Map.Entry<String,Integer> m:s)
        {
            if(m.getValue()==1)
                a += (m.getKey()+"");
            else
                a += (m.getKey()+""+m.getValue()+"");
        }
        return a;
    }
}

class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String formula = stringToString(line);
            
            String ret = new Solution().countOfAtoms(formula);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
