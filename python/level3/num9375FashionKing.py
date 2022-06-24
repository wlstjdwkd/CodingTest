from sys import stdin
N= int(stdin.readline())
for i in range(N):
    M= int(stdin.readline())
    dict={}
    for j in range(M):
        wear = list(stdin.readline().split())
        if wear[1] in dict:
            dict[wear[1]].append(wear[0])
        else:
            dict[wear[1]] = [wear[0]]

    cnt = 1

    for k in dict:
        cnt *= (len(dict[k])+1)
    print(cnt-1)
