def solution(numbers):
    answer = []
    for i in numbers:
        if i%2 ==0:
            answer.append(i+1)
        else:
            a=bin(i)[2:]
            a="0"+a
            one_idx=a.rfind("0")
            a=list(a)
            a[one_idx]="1"
            a[one_idx+1]="0"
            answer.append(int("".join(a),2))

    return answer


numbers=[2,7]
print(solution(numbers))