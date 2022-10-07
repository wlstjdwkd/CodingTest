from sys import stdin
import heapq
heap=[]
N=int(stdin.readline())

for i in range(N):
    a=int(stdin.readline())
    if a==0:
        try:
            print(heapq.heappop(heap))
        except:
            print(0)
    else:
        heapq.heappush(heap, a)