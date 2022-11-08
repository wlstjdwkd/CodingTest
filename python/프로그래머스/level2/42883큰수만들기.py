def solution(number, k):

    # answer = ""
    # q = list(number)
    # i = 0
    # while True:
    #     if q[i] == '9':
    #         i += 1
    #         continue
        
    #     if q[i+1] > q[i]:
    #         del q[i]
    #         k -= 1
    #         if k ==0:
    #             break
    #         i = 0
    #     else:
    #         i += 1
    #         if i == len(q)-1:
    #             for j in range(k):
    #                 del q[-1]
    #             k = 0
    #             break

    # answer += "".join(q)

    # return answer
    stack=[number[0]]
    for num in number[1:]:
        while len(stack) >0 and k>0 and stack[-1]<num:
            k-=1
            stack.pop()
        stack.append(num)
    if k>0:
        stack = stack[:-k]
    return "".join(stack)


print(solution("4177252841", 4))
