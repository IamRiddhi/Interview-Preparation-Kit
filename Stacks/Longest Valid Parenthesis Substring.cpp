class Solution {
public:
    int longestValidParentheses(string s) {
        int len = s.length();
        int maximum = 0;
        stack<int> st;
        st.push(-1);
        for(int i=0;i<len;i++)
        {
            if(s[i]=='(')
                st.push(i);
            else
            {
                st.pop();
                if(!st.empty())
                {
                    int index = st.top();
                    maximum = max(i-index,maximum);
                }
                else //pushing the wrong stuff.
                    st.push(i);
            }
        }
        return maximum;
    }
};