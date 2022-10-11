# https://school.programmers.co.kr/learn/courses/30/lessons/12914
def solution(n):
    if n < 3:
        return n
    d = [0]*(n+1)
    # 2칸까지밖에 경우가 없으니까
    d[1] = 1
    d[2] = 2
    for i in range(3, n+1):
        d[i] = d[i-1]+d[i-2]
    return d[n] % 1234567
