from sys import stdin
N=int(stdin.readline())
dp=[0]*(N+1)
dp[0], dp[1] = 0,1

for i in range(2, N+1):
    minValue=1e9
    j=1
    while(j**2)<=i:
        minValue = min(minValue,dp[i-(j**2)])
        j+=1
    dp[i] = minValue+1
print(dp[N])