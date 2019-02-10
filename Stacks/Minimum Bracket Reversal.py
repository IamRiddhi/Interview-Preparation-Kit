'''Minimum bracket Reversal

Given a string expression which consists only ‘}’ and ‘{‘. The expression may not be balanced. You need to find the minimum number of bracket reversals which are required to make the expression balanced.
Return -1 if the given expression can't be balanced.
Input Format :
String S
Output Format :
Required count
Sample Input 1 :
{{{
Sample Output 1 :
-1
Sample Input 2 :
{{{{}}
Sample Output 2 :
1

'''

s = str(input())
stack = []
count = 0
for i in range(len(s)):
  if s[i]=='{': #opening bracket
    stack.append(s[i])
  else: # closing bracket
  	if len(stack)==0:
  	    stack.append(s[i])
  	elif stack[-1]=='{':
  	    stack.pop()
  	else:
  	    stack.append(s[i])
if len(stack)%2==1:
  print('-1')
else:
  count = 0
  while not len(stack)==0:
      x = stack.pop()
      y = stack.pop()
      if y=='}' and x=='{':
          count += 2
      else:
          count += 1
  print(count)
  
