from sys import stdin, setrecursionlimit
input = stdin.readline
setrecursionlimit(10000)

def dfs(n):
    visited[n] = 1
    for v in graph[n]:
        if visited[v]:
            continue
        dfs(v)


def solve():
    global graph, visited

    N, M = map(int, input().split())

    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    visited = [0] * (N + 1)
    result = 0
    for i in range(1, N + 1):
        if visited[i]:
            continue
        result += 1
        dfs(i)
    print(result)


if __name__ == "__main__":
    solve()
