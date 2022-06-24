# from sys import stdin
# import math
# N = int(stdin.readline())
# n=math.factorial(N)
# cnt=0
# if 5<=N%10 and N%10<=9:
#     cnt+=1
# if N/10>=1:
#     cnt+=(int(N/10)*2)
# print(int(cnt))
from math import factorial
n = int(input())
cnt = 0
for x in str(factorial(n))[::-1]:
    if x != '0':
        break
    cnt += 1
print(cnt)