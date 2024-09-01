from sys import stdin
from math import factorial
input = stdin.readline


def binomial_coefficient(n, k):
    return factorial(n) // (factorial(k) * factorial(n - k))


def solve():
    N, K = map(int, input().split())
    print(binomial_coefficient(N, K))


if __name__ == "__main__":
    solve()
