A=[1,4,2]
B=[5,4,4]
answer=0
A.sort()
B.sort(reverse=True)
for i in range(len(A)):
    answer += (int(A[i])*int(B[i]))

print(answer)

#return sum(a*b for a, b in zip(sorted(A), sorted(B, reverse = True)))