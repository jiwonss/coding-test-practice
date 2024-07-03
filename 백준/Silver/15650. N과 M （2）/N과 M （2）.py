from sys import stdin
input = stdin.readline


def backtracking(start, k):
    if k == M:
        print(*result)
        return

    for i in range(start, N + 1):
        if visited[i]:
            continue
        visited[i] = 1
        result[k] = i
        backtracking(i + 1, k + 1)
        visited[i] = 0


def solve():
    global N, M, arr, visited, result

    N, M = map(int, input().split())
    arr = [i for i in range(1, N + 1)]

    visited, result = [0] * (N + 1), [0] * M
    backtracking(1, 0)


if __name__ == "__main__":
    solve()
