from sys import stdin
from collections import deque
input = stdin.readline


def out_of_bounds(x):
    return not (0 <= x < 100001)


def bfs(n, k):
    q = deque()
    visited = [-1] * 100001

    visited[n] = 0
    q.append(n)

    while q:
        x = q.popleft()
        if x == k:
            return visited[k]

        for v in [x * 2,  x - 1, x + 1]:
            if out_of_bounds(v) or visited[v] != -1:
                continue
            if v == x * 2:
                visited[v] = visited[x]
                q.appendleft(v)
            else:
                visited[v] = visited[x] + 1
                q.append(v)


def solve():
    N, K = map(int, input().split())

    print(bfs(N, K))


if __name__ == "__main__":
    solve()
