from sys import stdin
from collections import deque

input = stdin.readline


def bfs():
    q = deque()
    q.append([A, 1])

    while q:
        x, cnt = q.popleft()

        if x == B:
            return cnt

        for v in [2 * x, x * 10 + 1]:
            if v < 1 or v > B:
                continue
            q.append([v, cnt + 1])

    return -1


def solve():
    global A, B

    A, B = map(int, input().split())

    print(bfs())


if __name__ == "__main__":
    solve()
