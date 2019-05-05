void topologicalUtil(stack<int> *s, int **adj,int k,int *visited,int i)
{
    visited[i] = 1;
    for(int j=0;j<k;j++)
        if(adj[i][j] && !visited[j])
            topologicalUtil(s,adj,k,visited,j);
    s->push(i);
}
string topologicalSort(int **adj,int k)
{
    stack<int> *s = new stack<int>();
    int *visited = new int[k];
    fill(visited,visited+k,0);
    for(int i=0;i<k;i++)
        if(!visited[i])
            topologicalUtil(s,adj,k,visited,i);
    string ans = "";
    while(!s->empty())
    {
        char ch = (char)(s->top()+97);
        ans+= ch;
        s->pop();
    }
    return ans;
}
string printOrder(string dict[], int n, int k)
{
    int ** adj = new int*[k];
    for(int i=0;i<k;i++)
    {
        adj[i] = new int[k];
        fill(adj[i],adj[i]+k,0);
    }
    for(int i=0;i<n-1;i++)
    {
        string a = dict[i];
        string b = dict[i+1];
        for(int j=0;j<min(a.length(),b.length());j++)
            if(a[j]!=b[j])
            {
                adj[a[j]-'a'][b[j]-'a'] = 1;
                break;
            }
    }
    return topologicalSort(adj,k);
}
