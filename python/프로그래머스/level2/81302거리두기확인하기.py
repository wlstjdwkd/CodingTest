from collections import deque


def bfs(places, sx, sy):
    q = deque()
    visited = [[0]*5 for _ in range(5)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    q.append((sx, sy))

    visited[sx][sy] = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0 <= nx < 5 and 0 <= ny < 5 and (abs(nx-sx)+abs(ny-sy) <= 2) and visited[nx][ny] == 0:
                if places[nx][ny] == "P":
                    return False
                elif places[nx][ny] == "0":
                    visited[nx][ny] == 1
                    q.append((nx, ny))
    else:
        return True


def solution(places):
    answer = [1]*5
    for i in range(5):
        for j in range(5):
            for k in range(5):
                a = places[i][j][k]
                if a == "P":
                    if bfs(places[i], j, k) == False:
                        answer[i] = 0
                        break

    return answer


print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP",
      "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))
