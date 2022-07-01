from sys import stdin
N,M=map(int,stdin.readline().split())
visited=[0]*(N+1)
count=0
graph=[[]*N for i in range(N+1)]
for i in range(M):
    a,b = map(int, stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(start):
    visited[start] = 1
    for i in graph[start]:
        if visited[i]==0:
            dfs(i)

for i in range(1,N+1):
    if visited[i]==0:
        if graph[i]==0:
            count+=1
            visited[i]==1
        else:
            dfs(i)
            count+=1

print(count)