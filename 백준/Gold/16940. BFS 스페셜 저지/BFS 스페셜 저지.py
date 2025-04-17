from sys import stdin
from collections import deque

input = stdin.readline


def bfs():
    q.append(1)
    visited[1] = 1

    while q:
        n = q.popleft()
        result.append(n)
        for v in graph[n]:
            if visited[v]:
                continue
            visited[v] = 1
            q.append(v)


def solve():
    global N, graph, q, visited, result

    N = int(input())

    graph = [[] for _ in range(N + 1)]
    for _ in range(N - 1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    order = list(map(int, input().split()))

    index = [0] * (N + 1)
    for i in range(N):
        index[order[i]] = i

    for i in range(1, N + 1):
        graph[i].sort(key=lambda x: index[x])

    q, visited = deque(), [0] * (N + 1)
    result = []
    bfs()
    print(1 if result == order else 0)


if __name__ == "__main__":
    solve()
