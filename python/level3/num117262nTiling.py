from sys import stdin
N=int(stdin.readline())
lst=[1,2]
for i in range(2,1001):
    lst.append(lst[i-1]+lst[i-2])
print(lst[N-1]%10007)