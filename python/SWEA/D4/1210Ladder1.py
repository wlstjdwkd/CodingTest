for _ in range(10):
    a = int(input())
    ladders = list(list(map(int, input().split())) for _ in range(100))
    s=ladders[99].index(2)
    x,y=99,s
    visited=[[0]* 100 for _ in range(100)]
    while x!=0:
        visited[x][y]=1
        if y>0 and ladders[x][y-1] and visited[x][y-1]==0:
            y-=1
            continue
        elif y<99 and ladders[x][y+1] and visited[x][y+1]==0:
            y+=1
            continue
        else:
            x-=1

    answer=y

    print(f'#{a} {answer}')