for test_case in range(1,11):

    a= int(input())
    N=8
    arr=[list(input()) for _ in range(N)]
    aa=a//2
    answer=0
    #가로
    for i in range(0,N):
        for j in range(0,N-a+1):
            if arr[i][j:j+a] == arr[i][j:j+a][::-1]:
                answer+=1

    #세로
    for j in range(0, N):
        for i in range(0,N-a+1):
            k=''
            for l in range(i, i+a):
                k+=arr[l][j]
            if k==k[::-1]:
                answer+=1

    print('#{} {}'.format(test_case,answer))