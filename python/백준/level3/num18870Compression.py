from sys import stdin
N=int(stdin.readline())
X=list(map(int,stdin.readline().split()))
X2=sorted(list(set(X)))
dic={X2[i]: i for i in range(len(X2))}
for i in X:
    print(dic[i], end=' ')