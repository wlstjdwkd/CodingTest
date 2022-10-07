from sys import stdin
N, K=map(int, stdin.readline().split())
lst=[]
cnt=0
for i in range(N):
    lst.append(int(stdin.readline().rstrip()))
for i in range(N-1,-1,-1):
    if K==0:
        break
    if lst[i]>K:
        continue
    cnt+=int(K/lst[i])
    K-=int(K/lst[i])*lst[i]
print(cnt)