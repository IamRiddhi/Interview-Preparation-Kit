#include<bits/stdc++.h>
#include<cmath>
#include<climits>
#define test ll t; cin>>t; while(t--)
#define rep0(n) for(ll i=0;i<(n);i++)
#define rep1(n) for(ll i=1;i<=(n);i++)
using namespace std;
typedef long long ll;
int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    test
    {
        ll n,*a;
        cin>>n;
        a= new ll[n+1];
        a[0] = 0;
        rep1(n)
        {
            cin>>a[i];
            a[i] += a[i-1];
        }
        ll mid;
        for(mid=1;mid<=n;mid++)
            if(a[mid-1]==(a[n]-a[mid]))
                break;
        if(mid>n)
            mid = -1;
        cout<<mid<<endl;
    }
    return 0;
}
