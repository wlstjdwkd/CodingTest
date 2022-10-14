from collections import deque
priorities = [1, 1, 9, 1, 1, 1]
location = 0
answer = 0

# (순서, 중요도)를 원소로 갖는 덱
tasks = deque(enumerate(priorities))

# 모든 작업을 인쇄하거나 인쇄한 작업의 순서가 location과 같을 때까지 반복
while tasks:
    cnt_order, cnt_prio = tasks.popleft()
    # 남은 모든 작업들 중에 현재 작업 중요도보다 중요도가 높은게 하나라도 있으면
    if any(cnt_prio < task_prio[1] for task_prio in tasks):
        tasks.append((cnt_order, cnt_prio))
    else:
        answer += 1
        if cnt_order == location:
            break
print(answer)