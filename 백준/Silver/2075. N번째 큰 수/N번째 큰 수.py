from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def solve():
    N = int(input())
    heap = []
    for _ in range(N):
        temp = list(map(int, input().split()))
        for i in range(N):
            if len(heap) > N:
                heappop(heap)
            heappush(heap, temp[i])

    while len(heap) != N:
        heappop(heap)

    result = heap[0]
    print(result)


if __name__ == "__main__":
    solve()
