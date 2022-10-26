T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a=list(map(int,input().split()))
    answer=0
    for i in range(2, len(a)-1):
        if a[i]>a[i-1] and a[i]>a[i-2] and a[i]>a[i+1] and a[i]>a[i+2]:
            answer+=(a[i]-max(a[i-1],a[i-2],a[i+1],a[i+2]))
    print('#{} {}'.format(test_case,answer))