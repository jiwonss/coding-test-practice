from sys import stdin
from collections import Counter

input = stdin.readline


def solve():
    L = int(input())
    rollcake = [0 for _ in range(L + 1)]

    N = int(input())
    hope = [0, 0]
    for i in range(1, N + 1):
        P, K = map(int, input().split())
        if hope[1] < K - P + 1:
            hope = [i, K - P + 1]
        for k in range(P, K + 1):
            if rollcake[k]:
                continue
            rollcake[k] = i

    real = sorted(
        Counter([v for v in rollcake if v != 0]).items(),
        key=lambda x: (-x[1], x[0]),
    )[0]

    print(hope[0])
    print(real[0])


if __name__ == "__main__":
    solve()
