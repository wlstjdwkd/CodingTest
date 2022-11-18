for test_case in range(1, int(input())+1):
    a, b = input().split()

    answer = "no"
    chr = ""
    chr2 = ""
    for i in range(len(a)):
        chr += a[i]
        x = len(chr)

        if (len(a)-len(chr)) % len(chr) == 0:
            count = (len(a)/len(chr))
            if (chr * int(count)) == a:
                break

    for j in range(len(b)):
        chr2 += b[j]
        x = len(chr2)
        if (len(b)-len(chr2)) % len(chr2) == 0:
            count = (len(b)/len(chr2))
            if (chr2*int(count)) == b:
                break

    if chr == chr2:
        answer = "yes"

    print('#{} {}'.format(test_case, answer))
