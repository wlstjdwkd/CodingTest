from sys import stdin
from collections import deque
N=int(stdin.readline())
s=deque([])
for i in range(N):
    cmd = stdin.readline().split()
    if cmd[0] == 'push_front':
        s.appendleft(cmd[1])
    elif cmd[0] == 'push_back':

        s.append(cmd[1])
    elif cmd[0] == 'pop_front':
        if len(s) == 0:
            print(-1)
        else:
            print(s.popleft())
    elif cmd[0] == 'pop_back':
        if len(s) == 0:
            print(-1)
        else:
            print(s.pop())
    elif cmd[0] == 'size':
        print(len(s))
    elif cmd[0] == 'empty':
        if len(s) == 0:
            print(1)
        else:
            print(0)
    elif cmd[0] == 'front':
        if len(s) == 0:
            print(-1)
        else:
            print(s[0])
    elif cmd[0] == 'back':
        if len(s) == 0:
            print(-1)
        else:
            print(s[-1])
