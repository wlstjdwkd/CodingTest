from sys import stdin
N = int(stdin.readline())

time = [[0]*2 for _ in range(N)]
for i in range(N):
    time[i][0], time[i][1] = map(int, stdin.readline().split())

time.sort(key=lambda x:(x[1],x[0]))
cnt=1
end_time = time[0][1]
for i in range(1,N):
    if time[i][0]>=end_time:
        cnt+=1
        end_time = time[i][1]

print(cnt)