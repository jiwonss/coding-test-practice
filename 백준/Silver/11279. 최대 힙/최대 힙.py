from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def solve():
    N = int(input())

    heap = []
    for _ in range(N):
        x = int(input())
        if x:
            heappush(heap, -x)
        else:
            if heap:
                print(-heappop(heap))
            else:
                print(0)


if __name__ == "__main__":
    solve()
