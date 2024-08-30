from sys import stdin
input = stdin.readline

INF = 1e9


def solve():
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]

    for k in range(N):
        for i in range(N):
            for j in range(N):
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = 1

    for i in range(N):
        for j in range(N):
            print(graph[i][j], end=' ')
        print()


if __name__ == "__main__":
    solve()
