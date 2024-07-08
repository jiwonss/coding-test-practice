from sys import stdin
input = stdin.readline


def backtracking(start, k):
    if k == M:
        print(*result)
        return

    for i in range(start, N + 1):
        result[k] = i
        backtracking(i, k + 1)


def solve():
    global N, M, arr, result

    N, M = map(int, input().split())
    arr = [i for i in range(1, N + 1)]

    result = [0] * M
    backtracking(1, 0)


if __name__ == "__main__":
    solve()
