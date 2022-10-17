numbers=[4, 1, 2, 1]
target=4
total=0
def dfs(index, total):
    if(len(numbers)==index):
        if total==target:
            return 1
        return 0
    
    ret=0
    ret+=dfs(index+1, total+numbers[index])
    ret+=dfs(index+1, total-numbers[index])
    return ret

print(dfs(0,0))