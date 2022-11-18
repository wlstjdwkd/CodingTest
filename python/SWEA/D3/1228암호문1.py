for test_case in range(1, 11):
    a = int(input())
    answer = list(map(int,input().split()))
    b = int(input())
    order = list(input().split())
    num = 0
    num2 = 0

    for i in range(len(order)):
        if order[i] == 'I':
            num = int(order[i+1])
            num2 = int(order[i+2])
            for j in range(num2):
                answer.insert(num+j, int(order[i+2+j+1]))
        else:
            continue


    print('#{} {}'.format(test_case,' '.join(map(str, answer[:10]))))
