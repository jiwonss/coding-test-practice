from sys import stdin

input = stdin.readline


def dfs(k, start):
    if k == M:
        print(*result)
        return

    for i in range(start, N):
        result[k] = i + 1
        dfs(k + 1, i)


def solve():
    global N, M, result

    N, M = map(int, input().split())

    result = [0] * M
    dfs(0, 0)


if __name__ == "__main__":
    solve()
