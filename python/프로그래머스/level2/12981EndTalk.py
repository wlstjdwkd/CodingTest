n = 3
words = ["tank", "kick", "know", "wheel",
         "land", "dream", "mother", "robot", "tank"]
answer = [0, 0]
for i in range(1, len(words)):
    # print(words[i][0], words[i-1][-1])
    if words[i][0] != words[i-1][-1] or words[i] in words[:i]:
        answer[1] = i//n + 1
        answer[0] = i % n + 1
        # a,b=divmod(i,n)
        # answer[1]=a+1
        # answer[0]=b+1
        print(answer)
