T = int(input())
word_num = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
a_dict = {}  # 빠른 연산을 위해 위의 정보를 딕셔너리에 담을 변수 선언

for i in range(len(word_num)):  # 해당 영어정보를 딕셔너리에 담는다.
    a_dict[word_num[i]] = i

for order in range(1, T + 1):
    order2, N = input().split()
    N = int(N)
    array = list(input().split())

    cnt = [0] * 10  # 각 영어단어의 개수를 셀 리스트 선언
    for i in range(N):  # 입력받은 영어단어를 돌면서
        cnt[a_dict[array[i]]] += 1  # 해당 단어의 인덱스에 개수를 +1 해준다.

    print(f'{order2} ')

    for i in a_dict:  # one  ~ nin 까지 저장된 개수만큼 출력하기 위해
        print((i + ' ') * cnt[a_dict[i]])  # 저장된 개수만큼 곱해준다.