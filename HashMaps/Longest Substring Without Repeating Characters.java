class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int len = s.length();
        int start = 0;
        int i = 0;
        int maximum = 0;
        for(;i<len;i++)
        {
            char c = s.charAt(i);
            if(hmap.get(c)==null)
                hmap.put(c,i);
            else 
            { 
                int index = hmap.get(c);
                if(index<start)
                    hmap.put(c,i);
                else
                {
                    maximum = Math.max(maximum,i-start);
                    start = index + 1;
                    hmap.put(c,i);
                }
            }
        }
        return Math.max(maximum,i-start);
    }
}