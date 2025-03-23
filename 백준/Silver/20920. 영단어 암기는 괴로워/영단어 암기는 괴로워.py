from sys import stdin
from collections import defaultdict

input = stdin.readline


def solve():
    N, M = map(int, input().split())

    word = defaultdict(int)
    for _ in range(N):
        w = input().strip()
        if len(w) < M:
            continue
        word[w] += 1

    result = sorted(word.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))
    for k, v in result:
        print(k)


if __name__ == "__main__":
    solve()
