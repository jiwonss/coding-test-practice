from sys import stdin
input = stdin.readline


def solve():
    T = int(input())

    dp = [[0, 0] for _ in range(41)]
    dp[0], dp[1] = [1, 0], [0, 1]
    for i in range(2, 41):
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1]

    for _ in range(T):
        N = int(input())
        print(*dp[N])


if __name__ == "__main__":
    solve()
