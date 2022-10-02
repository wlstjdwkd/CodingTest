from sys import stdin
N,M=map(int,stdin.readline().split())
A,B,dir = map(int, stdin.readline().split())
array=[]
for i in range(N):
    array.append(list(map(int,stdin.readline().split())))
d=[[0]*M for _ in range(N)]
d[A][B]=1
dx=[-1,0,1,0]
dy=[0,1,0,-1]
turn_time=0


def turn_left():
    global dir
    dir-=1
    if dir==-1:
        dir=3

cnt =1
while True:
    turn_left()
    nA = A+ dx[dir]
    nB = B + dy[dir]
    # if A+dx[dir]>=1 and A+dx[dir]<=N and B+dy[dir]>=1 and B+dy[dir]<=M:
    if d[nA][nB]==0 and array[nA][nB]==0:
        cnt+=1
        d[nA][nB]=1
        turn_time=0
        A=nA
        B=nB
    else:
        turn_time+=1
    if turn_time==4:
        nA= A -dx[dir]
        nB = B -dy[dir]

        if array[nA][nB]==0:
            A=nA
            B=nB
            turn_time=0
        else:
            break


print(cnt)