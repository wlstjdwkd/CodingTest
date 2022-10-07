from sys import stdin
N=stdin.readline().split('-')
num=[]
for i in N:
    cnt = 0
    s= i.split('+')
    for j in s:
        cnt+= int(j)
    num.append(cnt)
n=num[0]
for i in range(1, len(num)):
    n -= num[i]
print(n)