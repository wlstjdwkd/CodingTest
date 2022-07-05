from sys import stdin
from collections import deque
N,K=map(int,stdin.readline().split())

visited=[0]*100001

def bfs(v):
    q=deque([v])
    visited[v]=1
    while q:
        v=q.popleft()
        if v==K:
            return visited[v] -1
        for i in (v-1, v+1, 2*v):
            if 0 <= i <= 100000 and not visited[i]:
                visited[i] = visited[v] +1
                q.append(i)

print(bfs(N))