from sys import stdin
from collections import deque
input = stdin.readline


def dfs(x):
    visited[x] = 1
    print(x, end=' ')
    for v in graph[x]:
        if visited[v]:
            continue
        dfs(v)


def bfs(n):
    q = deque([n])
    visited[n] = 1

    while q:
        x = q.popleft()
        print(x, end=' ')
        for v in graph[x]:
            if visited[v]:
                continue
            visited[v] = 1
            q.append(v)


def solve():
    global N, M, V, graph, visited
    N, M, V = map(int, input().split())

    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1, N + 1):
        graph[i].sort()

    visited = [0] * (N + 1)
    dfs(V)
    print()
    visited = [0] * (N + 1)
    bfs(V)


if __name__ == "__main__":
    solve()
