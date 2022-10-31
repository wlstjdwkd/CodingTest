from collections import deque


def solution(n):
    answer = ''
    while n > 0:
        if n % 3 == 0:
            answer += str(4)
            n = n//3-1
        else:
            answer += str(n % 3)
            n = n//3

    return answer[::-1]


print(solution(12))
