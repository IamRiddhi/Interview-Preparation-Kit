class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(s.length()<p.length())
            return ans;
        
        int freq[] = new int[26];
        for(int i=0;i<p.length();i++)
            freq[p.charAt(i)-'a']++;
        int match = 0;
        for(int i=0;i<26;i++)
            if(freq[i]>0)
                match++;
        int i;
        for(i=0;i<p.length();i++)
        {
            freq[s.charAt(i)-'a']--;
            if(freq[s.charAt(i)-'a']==0)
                match--;
        }
        if(match==0)
            ans.add(0);
        int j = 0;
        for(i=p.length();i<s.length();i++)
        {
            freq[s.charAt(j)-'a']++;
            if(freq[s.charAt(j)-'a']==1)
                match++;
            j++;
            freq[s.charAt(i)-'a']--;
            if(freq[s.charAt(i)-'a']==0)
                match--;
            if(match==0)
                ans.add(j);
        }
        return ans;
    }
}
