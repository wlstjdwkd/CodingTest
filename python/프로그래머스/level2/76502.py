#https://school.programmers.co.kr/learn/courses/30/lessons/76502
def check(brackets):
    stack=[]
    for i in brackets:
        if i in '({[':
            stack.append(i)
        else:
            if not stack:
                return False
            elif i==')':
                if stack[-1] != '(':
                    return False
                stack.pop()
            elif i=='}':
                if stack[-1] != '{':
                    return False
                stack.pop()
            else:
                if stack[-1] != '[':
                    return False
                stack.pop()
    if stack:
        return False
    return True

def solution(s):
    answer = 0
    s_len=len(s)
    for i in range(s_len):
        rotate = s[i:s_len]+s[:i]
        answer+=check(rotate)
    

        
    return answer