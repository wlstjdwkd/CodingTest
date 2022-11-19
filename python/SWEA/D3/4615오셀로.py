dir_list=[(1,0),(1,1),(0,1),(-1,0),(-1,-1),(0,-1),(-1,1),(1,-1)]
for test_case in range(1, int(input())+1):
    N,M= map(int,input().split())
    arr=list([0]*N for _ in range(N))
    #B=1
    #W=2
    arr[(N-1)//2][(N-1)//2], arr[N//2][N//2]=2,2
    arr[(N-1)//2][N//2], arr[N//2][(N-1)//2]=1,1
    bnum,wnum=0,0
    for i in range(M):
        h,w,nm=map(int,input().split())
        arr[h-1][w-1]=nm
        for j in range(8):
            x,y = dir_list[j]
            nx,ny = x+h-1,y+w-1
            reverse=[]
            while True:
                if nx<0 or ny<0 or nx>=N or ny>=N:
                    reverse=[]
                    break
                if arr[nx][ny]==0:
                    reverse=[]
                    break
                if arr[nx][ny]==nm:
                    break
                else:
                    reverse.append((nx,ny))
                nx+=x
                ny+=y
            for rx,ry in reverse:
                if nm==1:
                    arr[rx][ry]=1
                else:
                    arr[rx][ry]=2
    for i in range(N):
        for j in range(N):
            if arr[i][j]==1:
                bnum+=1
            elif arr[i][j]==2:
                wnum+=1
    
    
    print('#{} {} {}'.format(test_case,bnum,wnum))