s="110010101001"
answer = []
cnt=0
cnt0=0
while len(s)>1:
    cnt+=1
    cnt0+=s.count('0')
    s=s.replace('0','')
    len_value=len(s)
    s=bin(len_value)[2:]

answer.append(cnt)
answer.append(cnt0)
            
print(answer)