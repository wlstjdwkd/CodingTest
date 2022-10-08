# https://school.programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):
    answer = True
    cnt = 0
    for i in s:
        if i == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt == -1:
            return False
    if cnt != 0:
        answer = False

    return answer
