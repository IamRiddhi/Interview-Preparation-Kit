#include<bits/stdc++.h>
#include<cmath>
#include<climits>
#define test ll t; cin>>t; while(t--)
#define rep0(n) for(ll i=0;i<(n);i++)
#define rep1(n) for(ll i=1;i<=(n);i++)
using namespace std;
typedef long long ll;
void swap(ll*a,ll *b)
{
    ll temp = *a;
    *a = *b;
    *b = temp;
}
int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    test
    {
        ll n,*a;
        char ch;
        cin>>n;
        a= new ll[n];
        rep0(n)
            cin>>a[i];
        ll lo = 0;
        ll mid = 0;
        ll hi = n-1;
        while(mid<=hi)
        {
            switch(a[mid])
            {
                case 0: swap(&a[lo],&a[mid]);
                        mid++;
                        lo++;
                        break;
                case 1: mid++;
                        break;
                case 2: swap(&a[mid],&a[hi]);
                        hi--;
                        break;
            }
        }
        rep0(n)
            cout<<a[i]<<" ";
        cout<<endl;
    }
    return 0;
}
