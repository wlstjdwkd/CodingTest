from sys import stdin
from collections import deque
from turtle import st
N, M= map(int,stdin.readline().split())
graph=[[]*N for i in range(N+1)]
for i in range(M):
    a,b=map(int, stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited=[0]*(N+1)
def bfs(start):
    q = deque()
    q.append(start)
    visited[start]=1
    while q:
        start = q.popleft()
        for i in graph[start]:
            if visited[i]==0:
                q.append(i)
                visited[i]== visited[start]+1
        cnt = 0
        for i in range(N):
            if visited[i] !=0:
                cnt +=visited[i]
        return cnt

result=[]
answer=[]
for i in range(N):
    result.append(bfs(i))

for i in range(N):
    if result[i] == min(result):
        answer.append(i)
print(min(answer)+1)