from collections import Counter
def solution(want, number, discount):
    answer = 0
    cnt={}
    for i in range(len(want)):
        cnt[want[i]] = number[i]
    
    for j in range(len(discount)-9):
        if cnt == Counter(discount[j:j+10]):
            answer+=1
    return answer

want=["banana", "apple", "rice", "pork", "pot"]
number=[3, 2, 2, 2, 1]
discount=["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]
print(solution(want, number, discount))