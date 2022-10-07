import sys
N=int(sys.stdin.readline())
for i in range(N):
    s=input()
    stk=[]
    temp=True
    for i in s:
        if i == '(':
            stk.append(i)
        elif i ==')':
            if not stk:
                temp=False
                break
            elif stk[-1] == '(':
                stk.pop()

    if temp == True and not stk:
        print('YES')
    else:
        print('NO')