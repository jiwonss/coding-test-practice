from sys import stdin
input = stdin.readline


def backtracking(start, k):
    if k == M:
        print(*result)
        return

    for i in range(start, N):
        result[k] = arr[i]
        backtracking(i, k + 1)


def solve():
    global N, M, arr, result
    N, M = map(int, input().split())
    arr = sorted(list(map(int, input().split())))

    result = [0] * M
    backtracking(0, 0)


if __name__ == "__main__":
    solve()
