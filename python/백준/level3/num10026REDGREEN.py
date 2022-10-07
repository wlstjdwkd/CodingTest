from sys import stdin
from collections import deque
N=int(stdin.readline())
cnt=0
cnt2=0
dx=[-1,1,0,0]
dy=[0,0,-1,1]
a=[list(stdin.readline()) for i in range(N)]
q=deque()
visited=[[0]*N for i in range(N)]

def bfs(x,y):
    q.append((x,y))
    visited[x][y]=1
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx= x+dx[i]
            ny=y+dy[i]
            if 0<=nx<N and 0<=ny<N and a[nx][ny] == a[x][y] and not visited[nx][ny]:
                q.append((nx,ny))
                visited[nx][ny] = 1

#적록색약X
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            cnt+=1

#적록색약
visited=[[0]*N for i in range(N)]
for i in range(N):
    for j in range(N):
        if a[i][j]=='G':
            a[i][j]='R'

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            cnt2+=1

print(cnt, cnt2)