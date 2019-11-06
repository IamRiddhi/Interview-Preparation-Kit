vector<int> Solution::nextPermutation(vector<int> &A) {
    int size = A.size();
    for(int i=size-2;i>=0;i--)
    {
        if(A[i]<A[i+1])
        {
            // sort(A.begin()+i+1,A.end());
            int f = i + 1;
            int l = size - 1;
            while(f < l)
            {
                int t = A[f];
                A[f] = A[l];
                A[l] = t;
                f++;
                l--;
            }
            int ind = upper_bound(A.begin()+i+1,A.end(),A[i])-A.begin();
            int t = A[i];
            A[i] = A[ind];
            A[ind] = t;
            return A;
        }
    }
        int f = 0;
        int l = size - 1;
        while(f < l)
        {
            int t = A[f];
            A[f] = A[l];
            A[l] = t;
            f++;
            l--;
        }
    return A;
}
