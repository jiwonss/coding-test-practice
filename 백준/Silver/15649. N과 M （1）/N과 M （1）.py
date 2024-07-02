from sys import stdin
input = stdin.readline


def backtracking(k):
    if k == M:
        print(*result)
        return

    for i in range(1, N + 1):
        if visited[i]:
            continue
        visited[i] = 1
        result[k] = i
        backtracking(k + 1)
        visited[i] = 0


def solve():
    global N, M, arr, visited, result

    N, M = map(int, input().split())
    arr = [i for i in range(1, N + 1)]

    visited, result = [0] * (N + 1), [0] * M
    backtracking(0)


if __name__ == "__main__":
    solve()
