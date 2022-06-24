from sys import stdin
N,M=map(int,stdin.readline().split())
s1=set([])
s2=set([])
for i in range(N):
    s1.add(stdin.readline().rstrip())
for i in range(M):
    s2.add(stdin.readline().rstrip())

s3 = sorted(s1&s2)
print(len(s3))
for i in s3:
    print(i)