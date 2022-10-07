target = int(input())
ans = abs(100-target)
M = int(input())
if M:
    broken = set(input().split())
else:
    broken = set()

for num in range(1000001):
    for N in str(num):
        if N in broken:
            break
    else:
        # min( 기존답, 번호누른 횟수 + 해당 번호로부터 타겟의 차이)
        ans = min(ans, len(str(num)) + abs(num - target))

print(ans)
