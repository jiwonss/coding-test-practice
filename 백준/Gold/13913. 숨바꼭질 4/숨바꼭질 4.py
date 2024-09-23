from sys import stdin
from collections import deque

input = stdin.readline


def out_of_bounds(x):
    return not (0 <= x < 100001)


def bfs(n, k):
    visited[n] = 0
    q.append(n)

    while q:
        x = q.popleft()

        if x == k:
            return

        for v in [x * 2, x - 1, x + 1]:
            if out_of_bounds(v) or visited[v] != -1:
                continue
            visited[v] = visited[x] + 1
            q.append(v)
            log[v] = x


def solve():
    global q, visited, log

    N, K = map(int, input().split())

    q, visited, log = deque(), [-1] * 100001, [-1] * 100001
    bfs(N, K)

    print(visited[K])

    result = [K]
    while K != N:
        result.append(log[K])
        K = log[K]
    print(*result[::-1])


if __name__ == "__main__":
    solve()
