for tc in range(1,int(input())+1):
    N= int(input())
    arr=list(input().split())
    answer=[]
    i=0
    r=(N+1)//2
    for _ in range(N//2):
        answer.append(arr[i])
        answer.append(arr[r])
        i+=1
        r+=1

    if N%2:
        answer.append(arr[N//2])

    print('#{}'.format(tc), ' '.join(answer))
