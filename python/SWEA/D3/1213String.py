for test_case in range(1, 11):
    case = int(input())
    a = input().rstrip()
    b = input().rstrip()

    answer = b.count(a)
    print('#{} {}'.format(case, answer))
