from sys import stdin

input = stdin.readline


dx, dy = [0, -1, 0, 1], [1, 0, -1, 0]


def solve():
    N = int(input())

    graph = [[0] * 101 for _ in range(101)]
    for _ in range(N):
        y, x, d, g = map(int, input().split())
        graph[x][y] = 1

        curve = [d]
        for i in range(g):
            for j in range(len(curve) - 1, -1, -1):
                curve.append((curve[j] + 1) % 4)

        for i in range(len(curve)):
            x += dx[curve[i]]
            y += dy[curve[i]]
            if 0 <= x < 101 and 0 <= y < 101:
                graph[x][y] = 1

    result = 0
    for i in range(100):
        for j in range(100):
            if (
                graph[i][j]
                and graph[i + 1][j]
                and graph[i][j + 1]
                and graph[i + 1][j + 1]
            ):
                result += 1
    print(result)


if __name__ == "__main__":
    solve()
