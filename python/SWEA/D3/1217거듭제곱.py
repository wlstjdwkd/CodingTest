for _ in range(10):
    test_case = int(input())
    a,b =map(int,input().split())
    answer = a
    for i in range(b-1):
        answer= answer*a

    print('#{} {}'.format(test_case,answer))