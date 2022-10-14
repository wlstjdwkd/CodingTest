clothes = [["yellow_hat", "headgear"], [
    "blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
answer = 0
closet = {}
count = 1
for cloth in clothes:
    key = cloth[1]
    value = cloth[0]
    closet[key].append(value)

for key in closet:
    count = count * (len(closet[key])+1)
answer = count-1
print(answer)
