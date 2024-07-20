from sys import stdin
from collections import defaultdict
input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        n = int(input())

        cloth = defaultdict(list)
        for _ in range(n):
            name, type = input().split()
            cloth[type].append(name)

        result = 1
        for v in cloth.values():
            result *= (len(v) + 1)
        print(result - 1)


if __name__ == "__main__":
    solve()
