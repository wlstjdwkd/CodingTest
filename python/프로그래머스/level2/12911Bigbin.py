answer = 0
n=78
cnt=str(bin(n)[2:]).count('1')
print(bin(n))
while str(bin(n)[2:]).count('1')!=str(bin(n+1)[2:]).count('1'):
    n+=1
    
print(n+1)