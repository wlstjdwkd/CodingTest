from sys import stdin
N,M=map(int,stdin.readline().split())
t=list(map(int,stdin.readline().split()))
arr=[0]*11
for i in t:
    arr[i]+=1

result=0
for j in range(1,M+1):
    N -= arr[j]
    result += arr[j]* N

print(result)
