from sys import stdin
import heapq
N=int(stdin.readline())
heap=[]
for i in range(N):
    a=int(stdin.readline())
    if a==0:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)
    else:
        if a<0:
            heapq.heappush(heap,(-a,a))
        else:
            heapq.heappush(heap,(a,a))