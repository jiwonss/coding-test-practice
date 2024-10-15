from sys import stdin

input = stdin.readline


def solve():
    A = list(input().strip())
    B = list(input().strip())

    N, M = len(A), len(B)

    dp = [[0] * 1001 for _ in range(1001)]
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if A[i - 1] == B[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
    print(dp[N][M])


if __name__ == "__main__":
    solve()
