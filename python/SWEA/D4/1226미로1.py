from collections import deque
def bfs(x,y):
    q=deque()
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    q.append((x,y))
    visited[x][y]=1
    check=0

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx<= 15 and 0<=ny<=15:
                if arr[nx][ny]==0 and visited[nx][ny]==0:
                    visited[nx][ny]=1
                    q.append((nx,ny))
                elif arr[nx][ny]==3:
                    check=1
                    break
        
        if check == 1:
            break
    return check





for tc in range(1,3):
    a=int(input())
    arr=list(list(map(int,input())) for _ in range(16))
    visited=[[0]*16 for _ in range(16)]
    i=-1
    j=-1
    for q in range(16):
        for w in range(16):
            if arr[q][w]==2:
                i=q
                j=w
                break
        
        if i!= -1:
            break

    res=bfs(i,j)

    print(f'#{tc} {res}')