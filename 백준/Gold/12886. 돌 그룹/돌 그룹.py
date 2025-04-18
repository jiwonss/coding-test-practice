from sys import stdin
from collections import deque

input = stdin.readline


def bfs():
    total = A + B + C
    group = tuple(sorted([A, B, C]))

    q = deque()
    visited = set()

    q.append(group)
    visited.add(group)

    while q:
        a, b, c = q.popleft()
        if a == b == c:
            return 1

        for x, y in [(a, b), (b, c), (a, c)]:
            if x == y:
                continue
            nx, ny = x + x, y - x
            new_group = tuple(sorted([nx, ny, total - nx - ny]))
            if new_group not in visited:
                visited.add(new_group)
                q.append(new_group)
    return 0


def solve():
    global A, B, C
    A, B, C = map(int, input().split())
    print(1 if bfs() else 0)


if __name__ == "__main__":
    solve()
