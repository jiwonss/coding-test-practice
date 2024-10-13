from sys import stdin
from collections import defaultdict

input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        N = int(input())

        i, prime_factor = 2, defaultdict(int)
        while i <= N:
            if N % i == 0:
                prime_factor[i] += 1
                N //= i
            else:
                i += 1

        result = sorted(prime_factor.items())
        for r in result:
            print(*r)


if __name__ == "__main__":
    solve()
