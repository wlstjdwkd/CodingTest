def solution(rows, columns, queries):
    answer = []
    x1, y1, x2, y2 = 0, 0, 0, 0
    cnt = 1
    lst = [[0 for i in range(columns+1)] for j in range(rows+1)]
    for i in range(1, rows+1):
        for j in range(1, columns+1):
            lst[i][j] = cnt
            cnt += 1

    for i in queries:
        x1 = i[0]
        y1 = i[1]
        x2 = i[2]
        y2 = i[3]
        min_num=columns*rows
        prev_num=lst[x1][y1]
        min_num=min(min_num,prev_num)
        for j in range(y1+1,y2+1):
            temp=lst[x1][j]
            lst[x1][j]=prev_num
            prev_num=temp
            min_num=min(min_num,prev_num)
        
        for j in range(x1+1,x2+1):
            temp=lst[j][y2]
            lst[j][y2] = prev_num
            prev_num=temp
            min_num=min(min_num,prev_num)
        
        for j in range(y2-1,y1-1,-1):
            temp=lst[x2][j]
            lst[x2][j]=prev_num
            prev_num=temp
            min_num=min(min_num,prev_num)
        
        for j in range(x2-1,x1-1,-1):
            temp=lst[j][y1]
            lst[j][y1]=prev_num
            prev_num=temp
            min_num=min(min_num,prev_num)

        answer.append(min_num)
        

    return answer


print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))
