from sys import stdin
from collections import deque
input = stdin.readline


def bfs(start):
    q = deque()
    visited = [-1] * (N + 1)

    q.append(start)
    visited[start] = 1

    while q:
        x = q.popleft()
        for v in graph[x]:
            if visited[v] != -1:
                continue
            visited[v] = visited[x] + 1
            q.append(v)

    return sum(visited[1:])


def solve():
    global N, graph

    N, M = map(int, input().split())

    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        A, B = map(int, input().split())
        graph[A].append(B)
        graph[B].append(A)

    bacon_number = []
    for i in range(1, N + 1):
        bacon_number.append([i, bfs(i)])

    result = sorted(bacon_number, key=lambda x: (x[1], x[0]))
    print(result[0][0])


if __name__ == "__main__":
    solve()
