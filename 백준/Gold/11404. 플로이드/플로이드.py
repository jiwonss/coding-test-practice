from sys import stdin

input = stdin.readline


def floyd_warshall():
    for i in range(n):
        city[i][i] = 0

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if city[i][j] > city[i][k] + city[k][j]:
                    city[i][j] = city[i][k] + city[k][j]


def solve():
    global n, city

    n = int(input())
    m = int(input())

    city = [[float("inf")] * n for _ in range(n)]
    for _ in range(m):
        a, b, c = map(int, input().split())
        city[a - 1][b - 1] = min(city[a - 1][b - 1], c)

    floyd_warshall()

    for i in range(n):
        for j in range(n):
            if city[i][j] == float("inf"):
                city[i][j] = 0

    for c in city:
        print(*c)


if __name__ == "__main__":
    solve()
