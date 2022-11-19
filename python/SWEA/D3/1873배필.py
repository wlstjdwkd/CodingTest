import sys
sys.stdin= open('input.txt','r')
def findme():
    for h in range(H):
        for w in range(W):
            for i in range(4):
                if lst[h][w] == my_dir_list[i]:
                    return (h,w,my_dir_list[i])

dir_list = ['U', 'D', 'L', 'R']
drc_list = [(-1, 0), (1, 0), (0, -1), (0, 1)]
my_dir_list = ['^', 'v', '<', '>']

for test_case in range(1, int(input())+1):
    H, W = map(int, input().split())
    lst = list(list(input()) for _ in range(H))
    num = int(input())
    lst_num = input()

    me_h, me_w, me= findme()

    for i in lst_num:
        if i =='S': #포탄
            bomb_idx= my_dir_list.index(me)
            b_h,b_w = drc_list[bomb_idx]
            bomb_h,bomb_w=me_h,me_w
            while 0<= bomb_h <H and 0<=bomb_w<W:
                if lst[bomb_h][bomb_w] == '#':
                    break
                elif lst[bomb_h][bomb_w] == '*':
                    lst[bomb_h][bomb_w]='.'
                    break
                bomb_h += b_h
                bomb_w += b_w

        else:
            me_idx = dir_list.index(i)
            h,w =drc_list[me_idx]
            me=my_dir_list[me_idx]

            if 0<= me_h +h < H and 0<=me_w+w<W and lst[me_h+h][me_w+w]=='.':
                lst[me_h][me_w]='.'
                me_h+=h
                me_w+=w
            lst[me_h][me_w] =me

    

    print('#', test_case, sep='', end=' ')
    for f in lst:
        print(*f, sep='')
