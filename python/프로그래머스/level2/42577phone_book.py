from multiprocessing.connection import answer_challenge


answer = True
phone_dict={}
phone_book=["119", "97674223", "1195524421"]
for key in phone_book:
    phone_dict[key] = 1
for phone_num in phone_dict:
    tmp=''
    for num in phone_num:
        tmp+=num
        if tmp in phone_dict and tmp != phone_num:
            answer=False

print(answer)