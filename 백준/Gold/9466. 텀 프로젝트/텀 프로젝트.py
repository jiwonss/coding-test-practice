from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
input = stdin.readline


def dfs(x, team):
    global result

    v = graph[x]

    visited[x] = 1
    team.append(x)

    if visited[v]:
        if v in team:
            result -= len(team[team.index(v):])
        return

    dfs(v, team)


def solve():
    global graph, visited, result

    T = int(input())
    for _ in range(T):
        n = int(input())
        temp = list(map(int, input().split()))

        graph = [0] * (n + 1)
        for i in range(n):
            graph[i + 1] = temp[i]

        result, visited = n, [0] * (n + 1)
        for i in range(1, n + 1):
            if visited[i]:
                continue
            dfs(i, [])
        print(result)


if __name__ == "__main__":
    solve()
