import sys
input = sys.stdin.readline

n, k = map(int, input().split())
p = 1000000007

def factorial(n):
    num = 1
    for i in range(2, n + 1):
        num = (num * i) % p
    return num

def square(n, k):
    if k == 0:
        return 1
    elif k == 1:
        return n

    t = square(n, k // 2)
    if k % 2:
        return t * t * n % p
    else:
        return t * t % p

top = factorial(n)
bottom = factorial(n - k) * factorial(k) % p

print(top * square(bottom, p - 2) % p)