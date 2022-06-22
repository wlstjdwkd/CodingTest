from sys import stdin
from collections import Counter
import statistics
N=int(stdin.readline())
m=[]
for i in range(N):
    m.append(int(stdin.readline()))
m.sort()
C=Counter(m).most_common()

print(round(sum(m)/len(m)))
print(int(statistics.median(m)))
if len(C)==1:
    print(C[0][0])
elif C[0][1]==C[1][1]:
    print(C[1][0])
else:
    print(C[0][0])
print(max(m)-min(m))