from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop

input = stdin.readline


def solve():
    N = int(input())

    problem, min_heap, max_heap = defaultdict(bool), [], []
    for _ in range(N):
        P, L = map(int, input().split())
        problem[P] = True
        heappush(min_heap, [L, P])
        heappush(max_heap, [-L, -P])

    M = int(input())
    for _ in range(M):
        op = input().split()

        if op[0] == "recommend":
            x = int(op[1])

            if x == 1:
                while not problem[-max_heap[0][1]]:
                    heappop(max_heap)
                print(-max_heap[0][1])
            else:
                while not problem[min_heap[0][1]]:
                    heappop(min_heap)
                print(min_heap[0][1])

        if op[0] == "add":
            P, L = map(int, op[1:])

            while not problem[-max_heap[0][1]]:
                heappop(max_heap)
            while not problem[min_heap[0][1]]:
                heappop(min_heap)

            problem[P] = True
            heappush(min_heap, [L, P])
            heappush(max_heap, [-L, -P])

        if op[0] == "solved":
            P = int(op[1])
            problem[P] = False


if __name__ == "__main__":
    solve()
