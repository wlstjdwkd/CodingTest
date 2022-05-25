# a, b = map(int, input().split())
# max=0
# min=0
# c=0
# d=0
# for i in range(a):
#     if a%i==0 and b%i==0:
#         min=i
#         c=i/a
#         d=i/b
#
# max=c*d*min
# print(min)
# print(max)
import math
a,b = map(int, input().split())
print(math.gcd(a,b))
print(math.lcm(a,b))