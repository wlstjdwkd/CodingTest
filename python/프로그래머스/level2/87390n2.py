n, left, right = 3, 2, 5

answer = []
a, b = divmod(left, n)
c, d = divmod(right, n)

while a != c or b != d:
    if a < b:
        answer.append(b+1)
    else:
        answer.append(a+1)
    if b == n-1:
        b = 0
        a += 1
        
    else:
        b+=1
if a < b:
    answer.append(b+1)
else:
    answer.append(a+1)
print(answer)
