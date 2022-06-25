from sys import stdin
N,M=map(int,stdin.readline().split())
K=list(map(int, stdin.readline().split()))
sum=[0]
temp=0
for _ in K:
    temp += _
    sum.append(temp)
for _ in range(M):
    i,j=map(int, stdin.readline().split())
    print(sum[j]-sum[i-1])