from collections import deque
from sys import stdin
N,M,V=map(int, stdin.readline().split())
graph=[[]*N for i in range(N+1)]
for i in range(M):
    a,b = map(int, stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(len(graph)):
    graph[i].sort()

visited=[0]*(N+1)
visited2=[0]*(N+1)
def dfs(start):
    visited[start] = 1
    print(start, end=' ')
    for i in graph[start]:
        if visited[i]==0:

            dfs(i)

def bfs(start):
    q= deque()
    q.append(start)
    visited2[start] = 1
    while q:
        start = q.popleft()
        print(start, end=' ')

        for i in graph[start]:
            if visited2[i]==0:
                q.append(i)
                visited2[i] = 1


dfs(V)

print()
bfs(V)