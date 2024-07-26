from sys import stdin
input = stdin.readline


def solve():
    T = int(input())

    dp = [0] * 11
    dp[1], dp[2], dp[3] = 1, 2, 4
    for i in range(4, 11):
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

    for _ in range(T):
        n = int(input())
        print(dp[n])


if __name__ == "__main__":
    solve()
