s = "3people  unFollowed me"
# s = ""
answer = ''
s = s.split()
for i in range(len(s)):
    # 첫문자가 알파벳일 경우 대문자로 만들고
    # 두번째 문자부터는 자동 소문자
    # 첫문자 알파벳 아니면 그대로
    s[i] = s[i].capitalize()

    answer = ' '.join(s)

    # i = i.toLowerCase()
    # answer += i[0].toUpperCase()+i[1:len(i)]
    # if i != a[-1]:
    #     answer += " "

# answer=s.toLowerCase().replace(/^[a-z]|\s[a-z]/g, (match) => match.toUpperCase());
print(answer)


# def solution(s):
#     s = s.split(" ")
#     for i in range(len(s)):
#         s[i] = s[i][:1].upper() + s[i][1:].lower()
#     return ' '.join(s)
