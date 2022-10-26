T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a=input().rstrip()
    cnt=97
    for i in range(len(a)):
        if a[i] ==chr(97+i):
            cnt+=1
        else:
            break
    print('#{} {}'.format(test_case,cnt-97))