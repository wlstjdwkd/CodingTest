from sys import stdin

N = stdin.readline().rstrip()

result = []
sum = 0

for i in N:
    if i.isalpha():
        result.append(i)
    else:
        sum += int(i)

result.sort()
if sum!=0:
    result.append(str(sum))

print(''.join(result))
