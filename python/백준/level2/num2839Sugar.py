N=int(input())
cnt=0
if N == 4 or N == 7:
    print(-1)
else:
    while True:
        if N % 5 == 0:
            cnt+= (N/5)
            break
        elif (N-3) % 5 ==0:
            cnt += ((N-3)/5)+1
            break
        elif N ==0:
          break
        else:
            N -=3
            cnt=cnt+1

    print(int(cnt))