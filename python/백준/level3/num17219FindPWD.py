from sys import stdin
N,M=map(int, stdin.readline().split())
dict={}
for i in range(N):
    a = stdin.readline().split()
    dict[a[0]] = a[1]
for i in range(M):
    q = stdin.readline().rstrip()
    print(dict[q])