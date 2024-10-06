from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def solve():
    N = int(input())
    k_class = sorted([list(map(int, input().split())) for _ in range(N)])

    heap = []
    heappush(heap, k_class[0][1])

    for i in range(1, N):
        start, end = k_class[i]
        if heap[0] <= start:
            heappop(heap)
        heappush(heap, end)

    result = len(heap)
    print(result)


if __name__ == "__main__":
    solve()
