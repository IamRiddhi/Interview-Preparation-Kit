#include<bits/stdc++.h>
bool check_palindrome(node* head)
{
      stack<int> data;
      node *temp = head;
      int length = 0;
      while(temp!=NULL)
      {
        data.push(temp->data);
        temp = temp->next;
        length++;
      }
      length /= 2;
      while(length--)
      {
        if((head->data)!=(data.top()))
           return false;
        head = head->next;
        data.pop();
      }
      return true;
}