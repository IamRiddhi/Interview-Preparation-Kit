#include <bits/stdc++.h>
using namespace std;

void next_permutation(vector<int> &A) {
    int size = A.size();
    for(int i=size-2;i>=0;i--)
    {
        if(A[i]<A[i+1])
        {
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
            for(int j=0;j<size;j++)
            	cout<<A[j];
            cout<<endl;
            return;
        }
    }
    cout<<"-1"<<endl;
}

int main() {
	int t; cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		vector<int> vc;
		for(int i=0;i<n;i++)
		{
			int x; cin>>x; 
			vc.push_back(x);
		}
		next_permutation(vc);
	}
	return 0;
}
