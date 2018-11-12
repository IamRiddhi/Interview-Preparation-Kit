n = int(input())
a = list(map(int,input().split()))
pre= []
pre.append(0)
dict = {}
for i in range(0,n):
    x = None
    if a[i]==1:
      x = 1
    else:
      x = -1
    pre.append(pre[i]+x)
maxLen = 0
for i in range(n+1):
  if pre[i] in dict:
    maxLen = max(i-dict[pre[i]],maxLen)
  else:
    dict[pre[i]] = i
print(maxLen)