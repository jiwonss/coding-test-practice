from sys import stdin
from collections import deque
input = stdin.readline


def bfs():
    q = deque()
    visited = [0] * (n + 1)

    q.append([1, 0])
    visited[1] = 1
    while q:
        x, k = q.popleft()

        if k == 2:
            return sum(visited) - 1

        for v in graph[x]:
            if visited[v]:
                continue
            q.append([v, k + 1])
            visited[v] = 1
    return 0


def solve():
    global n, graph

    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    print(bfs())


if __name__ == "__main__":
    solve()
