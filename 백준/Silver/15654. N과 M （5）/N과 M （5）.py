from sys import stdin

input = stdin.readline


def dfs(k):
    if k == M:
        print(*result)
        return

    for i in range(N):
        if visited[i]:
            continue
        visited[i] = 1
        result[k] = arr[i]
        dfs(k + 1)
        visited[i] = 0


def solve():
    global N, M, arr, visited, result

    N, M = map(int, input().split())
    arr = sorted(list(map(int, input().split())))

    visited, result = [0] * N, [0] * M
    dfs(0)


if __name__ == "__main__":
    solve()
