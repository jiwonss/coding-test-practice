from sys import stdin
input = stdin.readline


def backtracking(k):
    if k == M:
        print(*result)
        return

    for i in range(1, N + 1):
        result[k] = i
        backtracking(k + 1)


def solve():
    global N, M, arr, result

    N, M = map(int, input().split())
    arr = [i for i in range(1, N + 1)]

    result = [0] * M
    backtracking(0)


if __name__ == "__main__":
    solve()
