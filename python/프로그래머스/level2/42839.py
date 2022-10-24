from itertools import permutations


def check(x):
    if x < 2:
        return False
    for i in range(2, x):
        if x % i == 0:
            return False
    return True


def solution(numbers):
    answer = []
    per = []
    for i in range(1, len(numbers)+1):
        per = list(map(''.join, permutations(numbers, i)))
        per = set(per)
        for p in per:
            if check(int(p)):
                answer.append(int(p))

    answer = set(answer)
    return len(answer)


numbers = "011"
print(solution(numbers))
