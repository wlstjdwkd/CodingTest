N= input()

step = [(-2,-1), (-2,1), (-1,-2), (-1,2), (2,-1), (2,1),(1,-2),(1,2)]

row=int(N[1])
col=int(ord(N[0]))-int(ord('a')) + 1

count = 0
for i in step:
    if row+ i[1]>=1 and row + i[1] <=8 and col + i[0]>=1 and col + i[0]<=8:
        count+=1

print(count)