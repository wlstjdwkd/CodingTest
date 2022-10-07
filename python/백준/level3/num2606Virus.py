from sys import stdin
N=int(stdin.readline())
M=int(stdin.readline())
graph=[[]*N for i in range(N+1)]
for i in range(M):
    a,b = map(int,stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

cnt=0
visited = [0]*(N+1)
def dfs(start):
    global cnt
    visited[start] = 1
    for i in graph[start]:
        if visited[i]==0:
            dfs(i)
            cnt += 1


dfs(1)
print(cnt)