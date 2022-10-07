import sys
from collections import deque
N=int(sys.stdin.readline())
s=deque([])

for i in range(N):
    s.append(i+1)

while len(s)>1:
        s.popleft()
        s.append(s[0])
        s.popleft()

print(s.pop())