from collections import deque
from sys import stdin
N = int(stdin.readline())
for i in range(N):
    A, B = map(int, stdin.readline().split())
    q = deque()
    visited = [False] * 10001
    q.append((A, ""))

    while q:
        num, path = q.popleft()
        visited[num] = True

        if num == B:
            print(path)
            break

        # D 2배
        num2 = (2*num) % 10000
        if not visited[num2]:
            q.append((num2, path+"D"))
            visited[num2] = True

        #S -1
        num2 = (num-1) % 10000
        if not visited[num2]:
            q.append((num2, path+"S"))
            visited[num2] = True

        # L 왼쪽
        num2 = (10*num+(num//1000)) % 10000
        if not visited[num2]:
            q.append((num2, path+"L"))
            visited[num2] = True

        # R 오른쪽
        num2 = (num//10 + (num % 10)*1000) % 10000
        if not visited[num2]:
            q.append((num2, path+"R"))
            visited[num2] = True
