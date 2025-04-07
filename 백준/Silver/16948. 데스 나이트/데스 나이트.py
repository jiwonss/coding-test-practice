from sys import stdin
from collections import deque

input = stdin.readline


def out_of_bounds(r, c):
    return not (0 <= r < N and 0 <= c < N)


def bfs(r1, c1):
    q.append([r1, c1])
    visited[r1][c1] = 0

    while q:
        r, c = q.popleft()
        if r == r2 and c == c2:
            return visited[r][c]
        for nr, nc in [
            [r - 2, c - 1],
            [r - 2, c + 1],
            [r, c - 2],
            [r, c + 2],
            [r + 2, c - 1],
            [r + 2, c + 1],
        ]:
            if out_of_bounds(nr, nc) or visited[nr][nc] != -1:
                continue
            visited[nr][nc] = visited[r][c] + 1
            q.append([nr, nc])
    return -1


def solve():
    global N, r2, c2, q, visited

    N = int(input())
    r1, c1, r2, c2 = map(int, input().split())

    q = deque()
    visited = [[-1] * N for _ in range(N)]
    print(bfs(r1, c1))


if __name__ == "__main__":
    solve()
