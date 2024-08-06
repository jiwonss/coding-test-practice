from sys import stdin
from collections import deque
input = stdin.readline


def topological_sort():
    q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        n = q.popleft()
        result.append(n)
        for v in graph[n]:
            indegree[v] -= 1
            if indegree[v] == 0:
                q.append(v)


def solve():
    global N, graph, indegree, result

    N, M = map(int, input().split())

    graph = [[] for _ in range(N + 1)]
    indegree = [0] * (N + 1)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        indegree[b] += 1

    result = []
    topological_sort()
    print(*result)


if __name__ == "__main__":
    solve()
