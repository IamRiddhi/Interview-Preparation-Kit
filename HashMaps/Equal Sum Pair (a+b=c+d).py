n = int(input())
a = list(map(int,input().split()))
dict = {}
fl = False
for i in range(n):
  for j in range(i+1,n):
    if (a[i]+a[j]) in dict:
      print("true")
      fl = True
      break
    else:
      dict[a[i]+a[j]] = True
  if fl:
    break
if not fl:
  print("false")