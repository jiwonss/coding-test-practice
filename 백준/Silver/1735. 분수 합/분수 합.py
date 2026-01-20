from sys import stdin
from math import gcd

input = stdin.readline


def solve():
    n1, d1 = map(int, input().split())
    n2, d2 = map(int, input().split())

    n, d = d1 * n2 + d2 * n1, d1 * d2
    div = gcd(n, d)

    result = [n // div, d // div]
    print(*result)


if __name__ == "__main__":
    solve()
