from sys import stdin
from collections import defaultdict
input = stdin.readline


def solve():
    N, C = map(int, input().split())
    arr = list(map(int, input().split()))

    temp = defaultdict(int)
    for a in arr:
        temp[a] += 1

    result = sorted(temp.items(), key=lambda x: -x[1])
    for k, v in result:
        for _ in range(v):
            print(k, end=' ')


if __name__ == "__main__":
    solve()
