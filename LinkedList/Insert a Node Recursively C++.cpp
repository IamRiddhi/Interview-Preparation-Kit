Node* insertNodeRec(Node *head, int i, int data) 
{
   if(head==NULL)
     return head;
   else if(i==0)
   {
      Node *nd = new Node(data);
      nd->next = head;
      head = nd;
    }
    else
    {
      Node *temp = insertNodeRec(head->next,i-1,data);
      if(temp!=NULL)
        head->next= temp;
    }
    return head;
}