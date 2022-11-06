from itertools import permutations
from math import factorial


def solution(n, k):
    # answer = []
    # arr = ""
    # for i in range(1, n+1):
    #     arr += str(i)
    # nPr = permutations(arr, n)
    # li = list(map("".join, permutations(arr, n)))
    # answer = list(map(int,list(li[k-1])))

    lst = [x for x in range(1, n+1)]
    answer = []
    k -= 1
    for i in range(n, 0, -1):
        num = factorial(n-1)
        answer.append(lst[k//num])
        lst.pop(k//num)
        k %= num
        n-=1


    return answer


print(solution(3,5))
