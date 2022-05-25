N=int(input())
lst=[]

for i in range(N):
    lst.append(input())

set_lst=set(lst) #set로 변환해서 중복값을 제거
lst=list(set_lst) #다시 리스트로 변환
lst.sort() #알파벳 순서
lst.sort(key = len) #문자열 길이

for i in lst:
    print(i)