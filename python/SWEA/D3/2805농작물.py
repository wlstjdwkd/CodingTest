for test_case in range(1, int(input())+1):
    answer = 0
    a = int(input())
    arr = list(list(map(int, input())) for _ in range(a))
    b=0
    for i in range(a):
        for k in range(abs(a//2-i), a-abs(a//2-i)):
            answer += arr[i][k]
    print('#{} {}'.format(test_case, answer))
