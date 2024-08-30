from sys import stdin
from heapq import heappush, heappop
input = stdin.readline


def solve():
    N, K = map(int, input().split())

    jewel = sorted([list(map(int, input().split())) for _ in range(N)])
    bag = sorted([int(input()) for _ in range(K)])

    heap, result = [], 0
    for i in range(K):
        while jewel and jewel[0][0] <= bag[i]:
            heappush(heap, -jewel[0][1])
            heappop(jewel)
        if heap:
            result += -heappop(heap)
    print(result)


if __name__ == "__main__":
    solve()
