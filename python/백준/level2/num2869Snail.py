A,B,V = map(int, input().split())
# current=0
# cnt=0
#
#
# while True:
#     if current +A>=V:
#         cnt +=1
#         break
#     else:
#         current += A-B
#         cnt +=1
#
# print(cnt)
k=(V-B)/(A-B)
print(int(k) if k== int(k) else int(k)+1)