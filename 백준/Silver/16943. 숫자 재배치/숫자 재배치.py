from sys import stdin
from itertools import permutations

input = stdin.readline


def solve():
    A, B = input().split()

    candidate = set()
    for p in permutations(list(A), len(A)):
        C = int("".join(p))
        if p[0] == "0" or C >= int(B):
            continue
        candidate.add(C)

    print(max(candidate) if candidate else -1)


if __name__ == "__main__":
    solve()
