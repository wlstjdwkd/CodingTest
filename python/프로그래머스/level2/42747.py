citations = [3, 0, 6, 1, 5]
answer = 0
citations.sort(reverse=True)
for i in range(len(citations)):
    if citations[i] >= i+1:
        answer = i+1
print(answer)
