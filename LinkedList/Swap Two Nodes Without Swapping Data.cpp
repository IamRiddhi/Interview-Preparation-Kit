node* swap_nodes(node *head,int i,int j)
{
      node *temp = head;
      int pos1 = min(i,j);
      int pos2 = max(i,j);
      node* previ = NULL;
      node* prevj = NULL;
      node* curi = temp;
      node* curj = temp;
      int p = 0;
      while(temp!=NULL)
      {
        if(p<pos1)
        {
          previ = temp;
          prevj = temp;
          temp = temp->next;
          curi = temp;
          curj = temp;
        }
        else if(p<pos2)
        {
          prevj = temp;
          temp = temp->next;
          curj = temp;
        }
        else
          break;
        p++;
      }
      if(prevj!=NULL)
        prevj->next = curi;
      if(previ!=NULL)
        previ->next = curj;
      else
        head = curj;
      node *t = curi->next;
      curi->next = curj->next;
      curj->next = t;
      return head;
}