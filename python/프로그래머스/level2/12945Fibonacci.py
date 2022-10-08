# https://school.programmers.co.kr/learn/courses/30/lessons/12945
def solution(n):
    answer = 0
    d = [0] * (n+1)
    d[1] = 1
    for i in range(2, n+1):
        d[i] = d[i-1]+d[i-2]
    return d[n] % 1234567

# a,b = 0,1
#     for i in range(num):
#         a,b = b,a+b
#     return a
