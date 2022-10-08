import math

arr = [2, 6, 8, 14]
answer = 0
# a = math.lcm(2, 6, 8, 14)
# b = math.gcd(2, 6, 8, 14)
# print(a, b)

for i in range(1, len(arr)):
    # for j in range(max(arr[i], arr[i-1]), (arr[i]*arr[i-1])+1):
    #     if j % arr[i] == 0 and j % arr[i-1] == 0:
    #         answer = j
    #         arr[i] = answer
    #         break
    answer = math.lcm(arr[i-1], arr[i])
    arr[i] = answer


print(answer)
