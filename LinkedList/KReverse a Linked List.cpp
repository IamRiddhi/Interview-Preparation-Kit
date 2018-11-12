pair<node*,node*> reverse(node* head,int k)
{
    node* prev = NULL;
    node* cur = head;
    node* next;
    int c = 0;
    while(cur!=NULL && c<k)
    {
        next = cur->next;
        cur->next = prev;
        prev = cur;
        cur = next;
        c++;
    }
    return make_pair(prev,cur);
}
node* kReverse(node* head,int n)
{
    node* tail = NULL;
    node *temp = head;
    while(temp!=NULL)
    {
      pair<node*,node*> p = reverse(temp,n);
      if(tail==NULL)
        head = p.first;
      else
        tail->next = p.first;
      tail = temp;
      temp = p.second;
    }
    return head;
}
