# https://school.programmers.co.kr/learn/courses/30/lessons/12978

import heapq


def dijkstra(dist, adj):
    q = []
    heapq.heappush(q, (0, 1))
    while q:
        cost, node = heapq.heappop(q)
        for c, n in adj[node]:
            #현재 노드를 거쳐서 다른노드를 가는게 더빠른 경우
            if cost+c < dist[n]:
                dist[n] = cost+c
                heapq.heappush(q, (cost+c, n))


def solution(N, road, K):
    #1에서의 거리
    dist = [float('inf')] * (N+1)
    dist[1] = 0

    #인접노드랑 인접 거리
    adj = [[] for i in range(N+1)]

    for r in road:
        adj[r[0]].append((r[2], r[1]))
        adj[r[1]].append((r[2], r[0]))
    dijkstra(dist, adj)
    return len([i for i in dist if i <= K])
