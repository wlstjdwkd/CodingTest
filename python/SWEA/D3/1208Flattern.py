T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    '''

        이 부분에 여러분의 알고리즘 구현이 들어갑니다.

    '''
    a= int(input())
    b=list(map(int,input().split()))
    answer=0
    for i in range(a):
        max_idx=b.index(max(b))
        min_idx=b.index(min(b))
        b[max_idx]-=1
        b[min_idx]+=1
    answer=max(b)-min(b)
    print('#{} {}'.format(test_case, answer))