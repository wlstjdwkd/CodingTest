from itertools import permutations

def calc(op, idx, exp):
    if exp.isdigit():
        return str(exp)
    else:
        if op[idx]== '*':
            tmp=[]
            split_data = exp.split('*')
            for s in split_data:
                tmp.append(calc(op,idx+1,s))
            return str(eval("*".join(tmp)))
        
        if op[idx] == '-':
            tmp=[]
            split_data = exp.split('-')
            for s in split_data:
                tmp.append(calc(op,idx+1,s))
            return str(eval("-".join(tmp)))
        
        if op[idx] =='+':
            tmp = []
            split_data = exp.split('+')
            for s in split_data:
                tmp.append(calc(op,idx+1,s))
            return str(eval("+".join(tmp)))

def solution(expression):
    answer=0
    operations = list(permutations(['*', '+', '-'], 3))

    for op in operations:
        result = abs(int(calc(op, 0, expression)))
        answer = max(result, answer)
    return answer

print(solution("100-200*300-500+20"))