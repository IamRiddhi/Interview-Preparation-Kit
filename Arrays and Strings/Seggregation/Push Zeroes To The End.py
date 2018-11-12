n = int(input())
a = list(map(int,input().split()))
j = 0
for i in range(n):
  if a[i]!=0:
    (a[j],a[i]) = (a[i],a[j])
    j += 1
for i in range(n):
  print(a[i],end=" ")
  	