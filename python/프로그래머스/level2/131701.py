from collections import deque


def solution(elements):
    answer = 0

    a = set()
    q = deque(elements)
    elements2 = elements+elements[:-1]
    print(elements2)
    # for j in range(len(elements)):

    for i in range(1, len(elements)):
        for j in range(len(elements)):

            b = j+i
            a.add(sum(elements2[j:b]))
            print(len(a)+1)

    # return answer
elements = [7, 9, 1, 1, 4]
print(solution(elements))
