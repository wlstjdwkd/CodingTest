def solution(numbers):
    answer = ''
    lst = list(map(str, numbers))
    lst = sorted(lst, key=lambda x: x*3, reverse=True)
    for i in lst:
        answer += i
    if eval(answer) == 0:
        return "0"
    return answer


numbers = [0, 0, 0, 0]
print(solution(numbers))
