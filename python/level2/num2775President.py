L = int(input())

for i in range(L):
    a = int(input())
    b= int(input())
    f0 = [x for x in range(1, b+1)]
    for j in range(a):
        for k in range(1, b):
            f0[k] +=f0[k-1]
    print(f0[-1])