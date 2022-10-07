from sys import stdin
N= int(stdin.readline())
# def sol(n):
#     if n==1:
#         return 1
#     elif n==2:
#         return 1
#     elif n==3:
#         return 1
#     elif n==4:
#         return 2
#     elif n==5:
#         return 2
#     else:
#         return sol(n-1)+ sol(n-5)
lst = [1,1,1,2,2]
for i in range(5,100):
    lst.append((lst[i-1]+lst[i-5]))
for i in range(N):
    t= int(stdin.readline())
    print(lst[t-1])