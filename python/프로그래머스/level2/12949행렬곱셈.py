def solution(arr1, arr2):
    answer = [[]]
    a1=len(arr1)
    a2=len(arr2[0])
    answer=[[0]*a2 for _ in range(a1)]
    for i in range(a1):
        for j in range(a2):
            for k in range(len(arr2)):
                answer[i][j] += arr1[i][k]*arr2[k][j]

    return answer


print(solution([[1, 4], [3, 2], [4, 1]],
     [[3, 3], [3, 3]]))
