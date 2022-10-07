import sys
n=int(sys.stdin.readline())
N=set(map(int, input().split()))
m=int(sys.stdin.readline())
M=list(map(int, input().split()))

for i in M:
    print(1) if i in N else print(0)