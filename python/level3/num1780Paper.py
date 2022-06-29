from sys import stdin
from turtle import st
N=int(stdin.readline())
lst=[[0 for col in range(N/3)]for row in range(N/3)]
lst2=[[0 for col in range(N)] for row in range(N)]
for i in range(N):
    for j in range(N):
        lst[i][j] = stdin.readline()