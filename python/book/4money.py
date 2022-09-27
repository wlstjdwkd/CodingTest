from sys import stdin

N=int(stdin.readline())
M=list(map(int,stdin.readline().split()))
M.sort()

#처음에 1원 만들수 있는지 확인
target=1

for i in M:
    if target < i:
        break
    target += i

print(target)