from sys import stdin
from collections import deque
input = stdin.readline


def bfs(n, k):
    q = deque()
    visited = [0] * 100001

    q.append(n)
    visited[n] = 1

    while q:
        x = q.popleft()
        if x == k:
            print(visited[x] - 1)
            return
        for v in [2 * x, x - 1, x + 1]:
            if not 0 <= v <= 100000 or visited[v]:
                continue
            visited[v] = visited[x] + 1
            q.append(v)


def solve():
    N, K = map(int, input().split())

    bfs(N, K)


if __name__ == "__main__":
    solve()
