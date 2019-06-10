class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[256];
        int tot = 0; //distinct characters;
        for(int i=0;i<t.length();i++)
            freq[t.charAt(i)]++;
        for(int i=0;i<256;i++)
            if(freq[i]>0)
                tot++;
        int window = 0;
        int mini = s.length() + 1;
        int matches = 0;
        int start = 0;
        int end = -1;
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)]--;
            if(freq[s.charAt(i)]==0)
                matches++;
            while(matches==tot)
            {
                if(mini>i-window+1)
                {
                    mini = i - window + 1;
                    start = window;
                    end = i;
                }
                freq[s.charAt(window)]++;
                if(freq[s.charAt(window)]==1)
                    matches--;
                window++;
            }
        }
        if(end==-1)
            return "";
        return s.substring(start,end+1);
    }
}
