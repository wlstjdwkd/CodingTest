from sys import stdin
N=int(stdin.readline())
M=list(map(int,stdin.readline().split()))

M.sort()

result=0
count=0

for i in M:
    count+=1
    if count>=i:
        result+=1
        count=0

print(result)