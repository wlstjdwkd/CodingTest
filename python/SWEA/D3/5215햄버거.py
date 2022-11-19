def dfs(index, sTaste, sKcal):
    global maxTaste
    if sKcal> L:
        return

    if maxTaste<sTaste:
        maxTaste = sTaste

    if index==N:
        return
    
    taste,kcal= a[index]

    dfs(index+1,sTaste+taste,sKcal+kcal)
    dfs(index+1,sTaste,sKcal)

for test_case in range(1, int(input())+1):
    N, L = map(int, input().split())
    maxTaste = 0
    cal_sum = 0
    a = [[0]*2 for _ in range(N)]
    for i in range(N):
        a[i][0], a[i][1] = map(int, input().split())
    
    dfs(0,0,0)
    
    print('#{} {}'.format(test_case,maxTaste))
