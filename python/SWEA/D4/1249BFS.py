from collections import deque
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

t = int(input())
for i in range(1, t+1):
    n = int(input())
    arr = list(list(map(int, input())) for _ in range(n))
    answer = 0
    q = deque()
    q.append((0, 0))
    time = [[99999] * n for _ in range(n)]
    time[0][0]=0
    while q:
        x, y = q.popleft()
        for j in range(4):
            nx = x + dx[j]
            ny = y + dy[j]
            if 0 <= nx < n and 0 <= ny < n:
                if time[x][y] + arr[nx][ny] < time[nx][ny]:
                    time[nx][ny] = time[x][y] + arr[nx][ny]
                    q.append((nx, ny))

    answer = time[-1][-1]

    print(f'#{i} {answer}')
