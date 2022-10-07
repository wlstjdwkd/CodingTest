# N,K=map(int, input().split())
# lst= [0 for i in range(1001)]
# num=0
# for i in range(N):
#     if num+K > N:
#         num = num+K-N
#     else:
#         num = num+K
#     lst[i]=num
#
# for j in lst:
#     if lst[j] == 0:
#         break
#     if j==0:
#         print("<")
#     print("%d," %lst[j], end='')
#
#     if j==N:
#         print(">")
#     # else:
#     #     print(", ")
from collections import deque
N,K=map(int, input().split())
s=deque([])
for i in range(1,N+1):
    s.append(i)
print('<',end='')
while s:
    for i in range(K-1):
        s.append(s[0])
        s.popleft()
    print(s.popleft(), end='')
    if s:
        print(', ',end='')
print('>')