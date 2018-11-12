n = int(input())
a = list(map(int,input().split()))
dict = {}
minLen = n
for i in range(n):
  if a[i] in dict:
    minLen = min(i-dict[a[i]],minLen)
  dict[a[i]] = i
print(minLen)