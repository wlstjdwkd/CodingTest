from sys import stdin
N=int(stdin.readline())
lst=[0 for i in range(20)]
for i in range(N):
    cmd=stdin.readline().split()
    if cmd[0] == 'add':
        lst[int(cmd[1])-1]=1
    elif cmd[0] == 'remove':
        lst[int(cmd[1])-1]=0
    elif cmd[0] == 'check':
        if lst[int(cmd[1])-1] ==1:
            print(1)
        else:
            print(0)
    elif cmd[0] == 'toggle':
        if lst[int(cmd[1])-1] ==1:
            lst[int(cmd[1])-1] = 0
        else:
            lst[int(cmd[1])-1] = 1
    elif cmd[0] == 'all':
        for i in range(20):
            lst[i]=1
    elif cmd[0] == 'empty':
        for i in range(20):
            lst[i]=0