from sys import stdin
N = int(stdin.readline())

result_minus = 0
result_zero = 0
result_plus = 0

board = [list(map(int, input().split()))for _ in range(N)]


def dfs(x, y, n):
    global result_minus, result_zero, result_plus

    num_check = board[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if (board[i][j] != num_check):
                #같은 수로 이루어져 있지 않다면, 9등분 하기
                for k in range(3):
                    for l in range(3):
                        dfs(x+k*n//3, y+l*n//3, n//3)
                #같지 않으니까 loop 종료
                return

    if num_check == -1:
        result_minus += 1
    elif num_check == 0:
        result_zero += 1
    else:
        result_plus += 1


dfs(0, 0, N)
print(f'{result_minus}\n{result_zero}\n{result_plus}')
