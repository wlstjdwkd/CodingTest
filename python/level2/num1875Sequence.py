from sys import stdin
n=int(stdin.readline())
stack=[]
for i in range(n):
    a=int(stdin.readline())
    stack.append(a)
count=0
result=[]
for i in range(1, n+1):
    p=stack.pop()
    if p==i:
        count+=1
        result.append('+')
    else:
        for j in range(i, p):
            result.append('+')
        for k in range(count):
            result.append('-')
            count=1
