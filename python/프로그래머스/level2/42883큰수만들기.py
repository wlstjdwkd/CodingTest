def solution(number, k):
    stack= [number[0]]
    for n in number[1:]:
        while stack and int(n)>int(stack[-1]) and k>0:
            stack.pop()
            k-=1
        stack.append(n)

        if len(stack) == len(number)-k:
            break
    
    return ''.join(stack)

print(solution("1924",2))