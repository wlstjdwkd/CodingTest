from itertools import count
from sys import stdin
N=int(stdin.readline())
graph=[]
num=[]
for i in range(N):
    graph.append(list(map(int,stdin.readline().rstrip())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]
def dfs(x,y):
    if x<=-1 or y<=-1 or x>=N or y>=N:
        return False
    if graph[x][y]==1:
        global count
        count +=1
        graph[x][y]=0
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            dfs(nx,ny)
        return True
    return False

count=0
result=0

for i in range(N):
    for j in range(N):
        if dfs(i,j)==True:
            num.append(count)
            result+=1
            count=0
num.sort()
print(result)
for i in range(len(num)):
    print(num[i])