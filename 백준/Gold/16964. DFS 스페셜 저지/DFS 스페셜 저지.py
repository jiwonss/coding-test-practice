from sys import stdin

input = stdin.readline


def dfs(n):
    if visited[n]:
        return

    visited[n] = 1
    result.append(n)
    for v in graph[n]:
        if visited[v]:
            continue
        dfs(v)


def solve():
    global graph, visited, result

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

    visited = [0] * (N + 1)
    result = []
    dfs(1)

    print(1 if result == order else 0)


if __name__ == "__main__":
    solve()
