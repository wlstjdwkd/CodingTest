from sys import stdin
M,N=map(int,stdin.readline().split())
dict = {}
# lst=[]
# for i in range(1, M+1):
#     lst.append(stdin.readline())
#
# for i in range(N):
#     a=stdin.readline()
#     if 1<=a and a<=M:
#         print(lst[a])
#     else:
#         if a in lst:

for i in range(1, M + 1):
    a = stdin.readline().rstrip()
    dict[i] = a
    dict[a] = i

for i in range(N):
    quest = stdin.readline().rstrip()
    if quest.isdigit():
        print(dict[int(quest)])
    else:
        print(dict[quest])