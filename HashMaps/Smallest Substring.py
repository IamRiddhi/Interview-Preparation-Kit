

"""Given two strings string1 and string2 (named large and small), find the smallest substring in string1 containing all characters of string2 in O(n). You need to return the output substring.
Note : The characters of string2 need not to be present in same order in string1. That is, we need a substring which contains all characters of string2 irrespective of the order.
Return null if no substring with all characters is present.
Input format :
Line 1 : String 1
Line 2 : String 2
Output Format :
Smallest substring
Constraints :
1 <= Length of string1 & string2 <= 10^4
Sample Input 1 :
Looks for minimum string
mums
Sample Output 1 :
mum s"""



def check(freq,sfreq):
  for ch in freq.keys():
    if not(ch in sfreq and sfreq[ch]>=freq[ch]):
      return False
  return True

import sys
s1 = str(input())
s2 = str(input())
freqb = {}
for i in range(len(s2)):
  if s2[i] in freqb:
    freqb[s2[i]] += 1
  else:
    freqb[s2[i]] = 1
minimum = sys.maxsize
start = -1
sfreq = {}
ind = 0
indexTracker = []
out = []
i = 0
for i in range(len(s1)):
  if s1[i] in sfreq:
    sfreq[s1[i]] += 1
  else:
      sfreq[s1[i]] = 1
  if s1[i] in freqb:
    indexTracker.append(i)
  if check(freqb,sfreq):
    if minimum > (i-start):
      out = []
      minimum = i - start
      for j in range(start+1,i+1):
        out.append(s1[j])
    fl = False
    while sfreq[s1[indexTracker[ind]]]>freqb[s1[indexTracker[ind]]]:
      fl = True
      sfreq[s1[indexTracker[ind]]] -= 1
      ind += 1
      start = indexTracker[ind] - 1
      if minimum > (i-start):
      	out = []
      	minimum = i - start
      	for j in range(start+1,i+1):
        	out.append(s1[j])
    if not fl:
        sfreq[s1[indexTracker[ind]]] -= 1
        ind += 1
        start = indexTracker[ind] - 1
if len(out)==0:
  print("null")
else:
  print(*out,sep="")