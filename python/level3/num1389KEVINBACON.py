from sys import stdin
from collections import deque


def bfs(start):
    
    q.append(start)
    visited=[-1 for _ in range()]
    
    visited[start]=0
    while q:
        start = q.popleft()
        for i in graph[start]:
            if visited[i]==-1:
                q.append(i)
                visited[i]= visited[start]+1
        cnt = 0
        for i in range(N):
            if visited[i] != -1:
                cnt +=visited[i]
        return cnt

N, M= map(int,stdin.readline().split())
graph=[[]*N for i in range(N+1)]
q = deque()
result=[]
answer=[]

for i in range(M):
    a,b=map(int, stdin.readline().split())
    a-=1
    b-=1
    graph[a].append(b)
    graph[b].append(a)


for i in range(N):
    result.append(bfs(i))

# print(result.index(min(result))+1)
for i in range(N):
    if result[i] == min(result):
        answer.append(i)
print(min(answer)+1)



# from collections import deque

# def bfs(x):
#     q.append(x)
#     c = [-1 for _ in range(n)]
#     c[x] = 0
#     while q:
#         x = q.popleft()
#         for i in a[x]:
#             if c[i] == -1:
#                 c[i] = c[x] + 1
#                 q.append(i)
#     cnt = 0
#     for i in range(n):
#         if c[i] != -1:
#             cnt += c[i]
#     return cnt

# n, m = map(int, input().split())
# a = [[] for _ in range(n)]
# q, res, ans = deque(), [], []

# for _ in range(m):
#     x, y = map(int, input().split())
#     x -= 1; y -= 1
#     a[x].append(y)
#     a[y].append(x)

# for i in range(n):
#     res.append(bfs(i))

# for i in range(n):
#     if res[i] == min(res):
#         ans.append(i)
# print(min(ans)+1)