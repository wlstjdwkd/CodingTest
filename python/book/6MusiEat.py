#못품

import heapq
food_times=[3,1,2]
k=5

q=[]
for i in range(len(food_times)):
    # (음식 시간, 음식 번호)
    heapq.heappush(q, (food_times[i], i+1))
    
# 먹기 위해 사용한 시간
sum_value=0
# 직전에 다 먹은 음식 시간
previous=0
# 남은 음식 개수
length=len(food_times)

#q[0][0] 현재 음식 시간 - 이전 음식 시간 * 음식 수 
while sum_value + ((q[0][0]-previous)*length) <= k:
    now = heapq.heappop(q)[0]
    sum_value += (now-previous) * length
    length -=1
    previous = now
    
result = sorted(q, key = lambda x : x[1])