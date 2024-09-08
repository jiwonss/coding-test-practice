from sys import stdin
from collections import deque, defaultdict
input = stdin.readline


def bfs(start):
    q = deque()
    visited = [-1] * (N + 1)

    q.append(start)
    visited[start] = 0

    while q:
        x = q.popleft()
        for v in graph[x]:
            if visited[v] != -1:
                continue
            visited[v] = visited[x] + 1
            q.append(v)
    return max(visited)


def solve():
    global N, graph

    N = int(input())

    graph = [[] for _ in range(N + 1)]
    while True:
        a, b = map(int, input().split())

        if [a, b] == [-1, -1]:
            break

        graph[a].append(b)
        graph[b].append(a)

    candidate = defaultdict(list)
    for i in range(1, N + 1):
        candidate[bfs(i)].append(i)

    result = sorted(candidate.items(), key=lambda x: x[0])[0]
    print(result[0], len(result[1]))
    print(*result[1])


if __name__ == "__main__":
    solve()
