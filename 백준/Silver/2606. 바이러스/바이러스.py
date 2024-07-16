from sys import stdin
input = stdin.readline


def dfs(x):
    global result

    result += 1
    visited[x] = 1
    for v in graph[x]:
        if visited[v]:
            continue
        dfs(v)


def solve():
    global graph, visited, result

    n = int(input())
    k = int(input())

    graph = [[] for _ in range(n + 1)]
    for _ in range(k):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    visited, result = [0] * (n + 1), 0
    dfs(1)

    if result:
        print(result - 1)
    else:
        print(0)


if __name__ == "__main__":
    solve()
