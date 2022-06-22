from sys import stdin
from collections import Counter
n=stdin.readline()
N=stdin.readline().split()
m=stdin.readline()
M=stdin.readline().split()

C=Counter(N)
print(' '.join(f'{C[k]}' if k in C else '0' for k in M))