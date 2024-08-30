from sys import stdin
from heapq import heapify, heappush, heappop
input = stdin.readline


def solve():
    N = int(input())
    card = [int(input()) for _ in range(N)]

    heapify(card)

    result = 0
    while len(card) > 1:
        temp = sum([heappop(card) for _ in range(2)])
        result += temp
        heappush(card, temp)
    print(result)


if __name__ == "__main__":
    solve()
