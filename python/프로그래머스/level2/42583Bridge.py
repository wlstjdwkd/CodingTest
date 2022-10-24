from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    go=deque(truck_weights)
    q=deque([0]*bridge_length)
    goWeight=0

    while q:
        answer+=1
        if q[0] != 0:
            goWeight-=q[0]
        q.popleft()
        if go:
            if goWeight + go[0]<=weight:
                goWeight+=go[0]
                q.append(go.popleft())
            else:
                q.append(0)

    return answer


bridge_length=2
weight=10
truck_weights=[7,4,5,6]
print(solution(bridge_length, weight, truck_weights))