Node* deleteNodeRec(Node *head, int i) {
    if(head==NULL)
      return head;
    if(i==0)
    {
      Node *temp = head;
      head = head->next;
      free(temp);
    }
    else
    {
      Node *temp = deleteNodeRec(head->next,i-1);
      if(temp!=NULL)
        head->next = temp;
    }
    return head;
}