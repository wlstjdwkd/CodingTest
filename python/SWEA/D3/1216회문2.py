def check(lst):
    for i in range(len(lst)//2):
        if lst[i] != lst[-i-1]:
            return False

for _ in range(10):
    test_case=int(input())
    arr=list(list(input()) for _ in range(100))
    arr2=list(zip(*arr))
    answer = 1
    #가로
    for i in range(100,1,-1):
        if answer>=i:
            break
        for j in range(100-i+1):
            if answer==i:
                break
            for arr,arr2 in zip(arr,arr2):
                if check(arr[j:j+i]) or check(arr2[j:j+i]):
                    answer=i
                    break
    print('#{} {}'.format(test_case,answer))