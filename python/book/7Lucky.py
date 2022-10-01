from sys import stdin
N=stdin.readline().rstrip()

sum1=0

for i in range(len(N)//2):
    sum1+=int(N[i])

for i in range(len(N)//2, len(N)):
    sum1-=int(N[i])

if sum1==0:
    print("LUCKY")
else:
    print("READY")