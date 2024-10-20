from sys import stdin
from collections import defaultdict

input = stdin.readline


def solve():
    M, N = map(int, input().split())

    universe = defaultdict(int)
    for _ in range(M):
        planet = list(map(int, input().split()))
        value = sorted(set(planet))
        compress_map = {v: i for i, v in enumerate(value)}
        compress_arr = [compress_map[p] for p in planet]
        universe[tuple(compress_arr)] += 1

    result = 0
    for v in universe.values():
        result += v * (v - 1) // 2
    print(result)


if __name__ == "__main__":
    solve()
