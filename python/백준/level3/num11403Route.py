from sys import stdin
N=int(stdin.readline())
graph=[]
for i in range(N):
    graph.append(list(map(int,stdin.readline().split())))

#플로이드-워셜 알고리즘
for k in range(N): #경로 for문이 가장 상위 단계여야 누락되지 않는다
    for i in range(N):
        for j in range(N): 
            if (graph[i][k] == 1 and graph[k][j] == 1):
                graph[i][j] = 1


for i in graph:
    for j in i:
        print(j, end=" ")
    print()