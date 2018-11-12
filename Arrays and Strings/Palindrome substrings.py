s = str(input())
n = len(s)
#counting odd-length pallindrome
odd_count = 0
for i in range(n):
  mid = i
  odd_count += 1
  l = i - 1
  r = i + 1
  while l>=0 and r<n and s[l]==s[r]:
    odd_count += 1
    l -= 1
    r += 1
#counting even-length pallindrome
even_count = 0
for i in range(1,n):
  l = i - 1
  r = i
  while l>=0 and r<n and s[l]==s[r]:
    even_count += 1
    l -= 1
    r += 1
print(even_count+odd_count)
