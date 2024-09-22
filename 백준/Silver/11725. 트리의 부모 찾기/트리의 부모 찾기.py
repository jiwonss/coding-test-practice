from sys import stdin
from collections import deque

input = stdin.readline


def bfs(n):
    q = deque([n])

    while q:
        x = q.popleft()
        for v in tree[x]:
            if visited[v]:
                continue
            visited[v] = x
            q.append(v)


def solve():
    global tree, visited

    N = int(input())

    tree = [[] for _ in range(N + 1)]
    for _ in range(N - 1):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)

    visited = [0] * (N + 1)
    bfs(1)

    for i in range(2, N + 1):
        print(visited[i])


if __name__ == "__main__":
    solve()
