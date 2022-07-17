from sys import stdin
n=int(stdin.readline())
stack=[]
result=[]
count=1
temp=True
for i in range(1, n+1):
    a=int(stdin.readline())
    while count<= a:
        stack.append(count)
        result.append('+')
        count+=1
    if stack[-1] == a:
        stack.pop()
        result.append('-')
    else:
        temp=False

if temp == False:
    print('NO')
else:
    for i in result:
        print(i)
