#include <iostream>
using namespace std;

int main() {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
	    int *a = new int[n];
        for(int i=0;i<n;i++)
            cin>>a[i];
        int left_max = 0;
        int right_max = 0;
        int sum = 0;
        int l = 0;
        int r = n-1;
        while(l<r)
        {
            if(a[l]<a[r]) // water will get collected on l
            {
                left_max = max(left_max,a[l]);
                sum += (left_max-a[l]); // i know min(left_max,right_max) will be always equal to left_max as my l is here because there are some points on right which is greater than what i have seen in left so far hence making my l move. hence left_max is greater than some values on right and it is because of those values my l has moved. hence whatever be the right max, my left_max should be considered.
                l++;
            }
            else // water will get collected on r
            {
                right_max = max(right_max,a[r]);
                sum += (right_max-a[r]); // similar logic as of left.
                r--;
            }
        }
        cout<<sum<<endl;
    }
	return 0;
}