import sys
N=int(input())
lst=[]
for i in range(N):
    lst.append(int(sys.stdin.readline()))

lst.sort()

for i in lst:
    print(i)