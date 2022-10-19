from itertools import product


def solution(word):
    target = ['A', 'E', 'I', 'O', 'U']
    arr = []
    for i in range(1, 6):
        arr += list(map("".join, product(target, repeat=i)))

    arr.sort()

    for i in range(len(arr)):
        if arr[i] == word:
            return i + 1


word = "AAAAE"
print(solution(word))
