progresses = [99, 99, 99]
speeds = [1, 1, 1]
result = []
stack = []
cnt = 1
for i in range(len(progresses)):
    a, b = divmod(100-progresses[i], speeds[i])

    if b != 0:
        a += 1
    if not stack:
        stack.append(a)
    else:

        if stack[-1] >= a:
            cnt += 1
        else:
            stack.append(a)
            result.append(cnt)
            cnt = 1

        if i == len(progresses)-1:
            result.append(cnt)
print(result)
