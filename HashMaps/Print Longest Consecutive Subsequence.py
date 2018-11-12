a = list(map(int,input().split()))
n = a[0]
dict = {}
for i in range(1,n+1):
    if a[i] not in dict:
        dict[a[i]] = i
seen = {}
ans = 0
finalList = []
for i in range(1,n+1):
  if a[i] not in seen:
    seen[a[i]] = True
    curList= []
    
    # going back
    x = a[i] - 1
    while x in dict:
      curList.append(x)
      x -= 1
      seen[x] = True
      
    curList.reverse()
    curList.append(a[i])
    
    # going forward
    x = a[i] + 1
    while x in dict:
      curList.append(x)
      x += 1
      seen[x] = True
      
    if ans < len(curList):
      finalList = curList
      ans = len(finalList)
      
    elif ans == len(curList) and dict[curList[0]] < dict[finalList[0]]:
      finalList = curList
      
for i in range(len(finalList)):
    print(finalList[i])
      
