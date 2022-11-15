import math


def solution(str1, str2):
    
    answer = 0
    a1 = []
    a2 = []
    common = []
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            a1.append(str1[i:i+2].upper())
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            a2.append(str2[i:i+2].upper())

    aa = a1.copy()
    ab = a1.copy()
    for i in a2:
        ab.append(i) if i not in aa else aa.remove(i)

    for i in a2:
        if i in a1:
            a1.remove(i)
            common.append(i)

    if len(common)==0 and len(ab)==0:
        return 65536
    answer = float(len(common)/len(ab))

    return math.floor(answer*65536)


print(solution("E=M*C^2", "e=m*c^2"))
