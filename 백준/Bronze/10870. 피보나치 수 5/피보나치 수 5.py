def f_num(n):
    f0 = 0
    f1 = 1
    if n == 1:
        return f1
    elif n == 0:
        return f0
    else:
        return f_num(n-1) + f_num(n-2)


n = int(input())

print(f_num(n))