from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def solve():
    N = int(input())

    heap = []
    for _ in range(N):
        x = int(input())
        if x == 0:
            if heap:
                print(heappop(heap))
            else:
                print(0)
        else:
            heappush(heap, x)


if __name__ == "__main__":
    solve()
