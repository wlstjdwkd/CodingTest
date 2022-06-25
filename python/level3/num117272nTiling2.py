from sys import stdin
lst=[1,3]
N=int(stdin.readline())
for i in range(2,1001):
    lst.append(lst[i-1]+2*lst[i-2])
print(lst[N-1]%10007)