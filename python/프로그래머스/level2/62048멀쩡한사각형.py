# import math


# def solution(w, h):
#     answer = 1
#     a = 0
#     x = 0
#     share = 0
#     start = 0
#     end = 0
#     if w > h:
#         a = float(w/h)
#         b = a
#         share = w//h

#         for i in range(h//2):
#             start = math.floor(a-b)
#             end = math.ceil(a)
#             x += (end-start)
#             a += b
#         if h % 2 == 1:
#             if w % 2 == 1:
#                 start = math.floor(a-b)
#                 end = math.ceil(w/2)
#                 x += (end-start)
#                 return w*h-x*2+1
#             else:
#                 start = math.floor(a-b)
#                 end = w//2
#                 x += (end-start)
#                 return w*h-x*2

#         else:
#             return w*h-x*2

#     elif w < h:
#         a = float(h/w)
#         b = a
#         share = h//w

#         for i in range(w//2):
#             start = math.floor(a-b)
#             end = math.ceil(a)
#             x += (end-start)
#             a += b
#         if w % 2 == 1:
#             if h % 2 == 1:
#                 start = math.floor(a-b)
#                 end = math.ceil(h/2)
#                 x += (end-start)
#                 return w*h-x*2+1
#             else:
#                 start = math.floor(a-b)
#                 end = h//2
#                 x += (end-start)
#                 return w*h-x*2
#         else:
#             return w*h-x*2

#     # 둘이 같을 때
#     else:
#         return w*h-w
#     return answer
import math

def solution(w,h):
    return (w*h)-(w+h-math.gcd(w,h))


print(solution(100000000, 999999999))
