from sys import stdin
from collections import defaultdict
input = stdin.readline


def solve():
    N = int(input())

    card = defaultdict(int)
    for _ in range(N):
        t = int(input())
        card[t] += 1

    result = sorted(card.items(), key=lambda x: (-x[1], x[0]))
    print(result[0][0])


if __name__ == "__main__":
    solve()
