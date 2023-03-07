from sys import stdin
N= int(stdin.readline())

result_zero = 0
result_one = 0

board = [list(map(int,input().split())) for _ in range(N)]

def dfs(x,y,n):
    global result_zero,result_one

    num_check = board[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if(board[i][j] != num_check):
                for k in range(2):
                    for l in range(2):
                        dfs(x+k*n//2, y+l*n//2, n//2)
                return
    
    if num_check == 0:
        result_zero +=1
    else:
        result_one +=1

dfs(0,0,N)
print(f'{result_zero}\n{result_one}')