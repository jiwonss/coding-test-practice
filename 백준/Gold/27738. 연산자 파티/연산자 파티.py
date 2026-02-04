from sys import stdin
from math import lcm

input = stdin.readline


def solve():
    N = int(input())
    A, B, C, D, E, F = map(int, input().split())

    L = lcm(A, B, C, D, E, F)
    start = (N // L) * L

    X = 0
    for i in range(start + 1, N + 1):
        if i % A == 0:
            X = X + i
        if i % B == 0:
            X = X % i
        if i % C == 0:
            X = X & i
        if i % D == 0:
            X = X ^ i
        if i % E == 0:
            X = X | i
        if i % F == 0:
            X = X >> i
    print(X)


if __name__ == "__main__":
    solve()
