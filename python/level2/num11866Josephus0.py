# N,K=map(int, input().split())
# lst= [0 for i in range(1001)]
# num=0
# for i in range(N):
#     if num+K > N:
#         num = num+K-N
#     else:
#         num = num+K
#     lst[i]=num
#
# for j in lst:
#     if lst[j] == 0:
#         break
#     if j==0:
#         print("<")
#     print("%d," %lst[j], end='')
#
#     if j==N:
#         print(">")
#     # else:
#     #     print(", ")
