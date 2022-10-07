from sys import stdin
N=int(stdin.readline())
result=0
for i in range(1,N+1):
    lst = list(map(int,str(i)))
    s = i +sum(lst)
    if s==N:
        result=i
        break

print(result)