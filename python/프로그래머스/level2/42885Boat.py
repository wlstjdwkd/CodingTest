#https://school.programmers.co.kr/learn/courses/30/lessons/42885
from collections import deque

def solution(people, limit):
    people.sort()
    answer = 0
    people = deque(people)
    
    while people:
        if len(people) ==1:
            answer+=1
            break
        if people[0] + people[-1] <= limit:
            answer+=1
            people.popleft()
            people.pop()
        else:
            answer+=1
            people.pop()
    
    return answer