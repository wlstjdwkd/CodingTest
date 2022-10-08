answer = -1
s = "baabaa"

stack=[]
for i in s:
    if not stack:
        stack.append(i)
    else:
        if stack[-1] == i:
            stack.pop()
        else:
            stack.append(i)
if stack:
    print(0)

print(1)


