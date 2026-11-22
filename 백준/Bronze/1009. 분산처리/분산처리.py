from sys import stdin
input = stdin.readline

T = int(input())
for _ in range(T):
    a, b = map(int, input().split())
    n = pow(a, b, 10)
    print(n if n != 0 else 10)