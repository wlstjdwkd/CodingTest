from sys import stdin
N,M=map(int, stdin.readline().split())
lst=list(map(int, stdin.readline().split()))
start=1
end=max(lst)
while(start<=end):
    mid=int((start+end)/2)
    cnt=0
    for i in lst:
        if i>mid:
            cnt+=(i-mid)
    if cnt>=M:
        start=mid+1
    else:
        end=mid-1
print(end)