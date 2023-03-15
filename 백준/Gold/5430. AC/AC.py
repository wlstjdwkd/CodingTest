from sys import stdin
from collections import deque

N = int(stdin.readline())

for i in range(N):
    AC = stdin.readline().rstrip()
    M = int(stdin.readline())
    arr = deque(stdin.readline().rstrip()[1:-1].split(","))
    flag = 0
    cnt = 0

    if M == 0:
        arr = deque()

    for j in AC:
        if j == "R":
            cnt += 1
        else:
            if arr:
                if cnt % 2 == 0:
                    arr.popleft()
                else:
                    arr.pop()

            else:
                print("error")
                flag = 1
                break

    if flag == 0:
        if cnt % 2 == 0:
            print("["+",".join(arr)+"]")
        else:
            arr.reverse()
            print("["+",".join(arr)+"]")