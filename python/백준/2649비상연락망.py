from sys import stdin
n = int(stdin.readline())
graph = [[]*n for i in range(n+1)]
for i in range(n):
    a = stdin.readline().rstrip()
    lst = a.split()
    for j in range(1, len(lst)):
        graph[int(lst[0])].append(int(lst[j]))

visited = [0]*(n+1)


def dfs(start, time):
    visited[start] = 1
    # print(start, end=' ')
    for i in graph[start]:
        if visited[i] == 0:
            time += 1
            dfs(i, time)
    print(time)


dfs(1, 0)
