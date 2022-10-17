from collections import deque
prices=[1,2,3,2,3]
q=deque(prices)
    
answer = []
while q:
    cnt=0
    a=q.popleft()
    for i in q:
        cnt+=1

        if a>i:
            break
    
    answer.append(cnt)
    
print(answer)