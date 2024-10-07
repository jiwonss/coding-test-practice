from sys import stdin
from heapq import heapify, heappush, heappop

input = stdin.readline


def solve():
    n, m = map(int, input().split())
    status = list(map(int, input().split()))

    heapify(status)

    for _ in range(m):
        v = heappop(status) + heappop(status)
        heappush(status, v)
        heappush(status, v)

    result = sum(status)
    print(result)


if __name__ == "__main__":
    solve()
