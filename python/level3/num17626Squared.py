from sys import stdin
N=int(stdin.readline())
#dp=[0]*(N+1)
#dp[0], dp[1] = 0,1
dp=[0,1]
#자신의 수에서 그보다 작은 수의 제곱수를 빼는 것의 최소를
#더하고 거기서 한개를 더해주면 됨
#i-j**2
for i in range(2, N+1):
    minValue=1e9
    j=1
    while(j**2)<=i:
        minValue = min(minValue,dp[i-(j**2)])
        j+=1
    dp.append(minValue + 1)
    #dp[i] = minValue+1
print(dp[N])