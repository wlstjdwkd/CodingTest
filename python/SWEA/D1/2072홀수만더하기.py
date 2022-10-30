
for tc in range(1,int(input())+1):
    lst=list(map(int,input().split()))
    answer=0
    for i in lst:
        if i %2==1:
            answer+=i
    print(f'#{tc} {answer}')