T = int(input())

for i in range(T):
    x, y = map(int, input().split())
    z = y - x
    num = 1
    while True:
        if num**2 <= z <= (num+1)**2:
            break
        num += 1
    if num**2 == z:
        print(2*num - 1)
    elif num**2 < z <= num**2 + num:
        print(2*num)
    else:
        print((num*2) + 1)