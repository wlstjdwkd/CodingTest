for tc in range(1, int(input())+1):
    a,b,c=map(int,input().split())
    answer=0
    if c<a:
        answer= a-c
    elif c>b:
        answer=-1
    print('#{} {}'.format(tc,answer))