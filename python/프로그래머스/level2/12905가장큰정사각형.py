from itertools import chain


def solution(board):
    answer = 1234
    for i in range(1, len(board)):
        for j in range(1, len(board[0])):
            if board[i][j] == 1:
                board[i][j]=min(board[i-1][j],board[i][j-1],board[i-1][j-1])+1

    return max(chain(*board))**2


print(solution([[0,0,1,1],[1,1,1,1]]))
