from sys import stdin
N = int(input())
A = input().split()
x, y = 1, 1
plans = ['L', 'R', 'U', 'D']
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

for i in A:
    for j in range(len(plans)):
        if i == plans[j]:
            if x + dx[j] < 1 or x+dx[j] > N or y + dy[j] < 1 or y+dy[j] > N:
                continue
            x = x + dx[j]
            y = y + dy[j]


print(x, y)
