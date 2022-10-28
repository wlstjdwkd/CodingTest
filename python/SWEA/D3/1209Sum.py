T=int(input())
for i in range(1,T+1):
    lst=list(list(map(int,input().split())) for _ in range(100))
    sum=[]
    for j in range(10):
        sum.append(max(lst[j][:10]))

    print(f'#{i} {}')