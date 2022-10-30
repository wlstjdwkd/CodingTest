def solution(arr):
    answer = [0,0]
    

    arrlen = len(arr)
    def comp(x,y,n):
        init=arr[x][y]
        for i in range(x,x+n):
            for j in range(y,y+n):
                if arr[i][j] != init:
                    nn=n//2
                    comp(x,y,nn)
                    comp(x,y+nn,nn)
                    comp(x+nn,y,nn)
                    comp(x+nn,y+nn,nn)
                    return
        
        answer[init]+=1

    comp(0,0,arrlen)
    return answer


arr = [[1, 1, 0, 0], [1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 1, 1]]
print(solution(arr))