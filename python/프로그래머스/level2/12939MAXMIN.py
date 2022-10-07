s = "1 2 3 4"
answer = ''

a = list(map(int, s.split(" ")))
a.sort()
print(a)
answer += str(a[0]) + " " + str(a[-1])

print(answer)
