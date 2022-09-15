from itertools import combinations
import math
from sys import stdin

n, m = map(int, stdin.readline().split())
up = math.factorial(n)
down = (math.factorial(n-m))*(math.factorial(m))

print(up//down)
# for i in range(n):
#     arr.append(i)

# combi = list(combinations(arr, m))

# print(len(combi))
