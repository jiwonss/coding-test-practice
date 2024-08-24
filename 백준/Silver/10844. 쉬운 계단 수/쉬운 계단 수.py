from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    dp = [[0] * 10 for _ in range(N + 1)]
    for i in range(1, 10):
        dp[1][i] = 1

    mod = 1000000000
    for i in range(2, N + 1):
        for j in range(10):
            if j == 0:
                dp[i][j] = (dp[i - 1][1]) % mod
            if j == 9:
                dp[i][j] = (dp[i - 1][8]) % mod
            if 0 < j < 9:
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
    print(sum(dp[N]) % mod)


if __name__ == "__main__":
    solve()
