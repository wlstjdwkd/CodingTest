from sys import stdin
N=int(stdin.readline())
P=list(map(int,stdin.readline().split()))
sum=0
P.sort()
for i in range(N):
    for j in range(i+1):
        sum+=P[j]

print(sum)