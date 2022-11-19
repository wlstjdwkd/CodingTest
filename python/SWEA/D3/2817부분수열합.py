import itertools
for tc in range(1,int(input())+1):
    N,K=map(int,input().split())
    arr=list(map(int,input().split()))
    cnt=0
    for i in range(1,N+1):
        comb = itertools.combinations(arr,i)

        for x in comb:
            if sum(x)==K:
                cnt+=1

    print('#{} {}'.format(tc,cnt))