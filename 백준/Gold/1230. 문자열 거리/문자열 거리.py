from sys import stdin

input = stdin.readline


def solve():
    O = " " + input().rstrip("\n")
    N = " " + input().rstrip("\n")

    len_O, len_N = len(O) - 1, len(N) - 1
    INF = int(1e9)

    dp = [[[INF, INF] for _ in range(len_N + 1)] for _ in range(len_O + 1)]
    dp[0][0][0] = 0

    for i in range(len_O + 1):
        for j in range(1, len_N + 1):
            if i > 0 and O[i] == N[j]:
                dp[i][j][0] = min(dp[i - 1][j - 1])
            dp[i][j][1] = min(dp[i][j - 1][0] + 1, dp[i][j - 1][1])

    result = min(dp[len_O][len_N])
    print(result if result != INF else -1)


if __name__ == "__main__":
    solve()
