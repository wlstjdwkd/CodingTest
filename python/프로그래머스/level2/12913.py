
land = [[1,2,3,5],[5,6,7,8],[4,3,2,1]]
def solution(land):
    answer = 0
    for i in range(1,len(land)):
        for j in range(4):
        	#같은 열을 지날 수 없으므로
            land[i][j]=max(land[i-1][:j]+land[i-1][j+1:])+land[i][j]
    return max(land[-1])

print(solution(land))