#include<bits/stdc++.h>
#include<cmath>
#include<climits>
#define test ll t; cin>>t; while(t--)
#define rep0(n) for(ll i=0;i<(n);i++)
#define rep1(n) for(ll i=1;i<=(n);i++)
using namespace std;
typedef long long ll;
ll mod = 1000000007;
int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    test
    {
        ll n,*a;
        cin>>n;
        a= new ll[n];
        rep0(n)
            cin>>a[i];
        sort(a,a+n);
        ll minimum = LLONG_MAX;
        for(ll i=n-1;i>0;i--)
        {
            ll x = ceil(a[i]/2.0);
            ll ind = lower_bound(a,a+i,x)-a;
            minimum = min(minimum,ind+n-1-i);
        }
        cout<<minimum<<endl;
    }
    return 0;
}