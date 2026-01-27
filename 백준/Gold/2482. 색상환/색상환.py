from sys import stdin

input = stdin.readline
MOD = 1000000003


def solve():
    N = int(input())
    K = int(input())

    if K * 2 > N:
        print(0)
        return

    dp = [[0] * (K + 1) for _ in range(N + 1)]
    for i in range(N + 1):
        dp[i][0] = 1
        dp[i][1] = i

    for i in range(2, N + 1):
        for j in range(2, K + 1):
            dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD

    result = (dp[N - 1][K] + dp[N - 3][K - 1]) % MOD
    print(result)


if __name__ == "__main__":
    solve()
