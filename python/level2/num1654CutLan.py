from sys import stdin
K, N =map(int, input().split())
lst=[]
for i in range(K):
    lst.append(int(stdin.readline()))
start=1
end=max(lst)

while(start<=end):
    mid = int((start+end)/2)
    cnt=0
    for i in lst:
        cnt+=int(i/mid)
    if cnt>=N:
        start=mid+1
    else:
        end=mid-1
print(end)