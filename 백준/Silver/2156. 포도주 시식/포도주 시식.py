from sys import stdin

input = stdin.readline


def solve():
    n = int(input())
    wine = [0] + [int(input()) for _ in range(n)]

    if n == 1:
        print(wine[1])
        return

    dp = [0] * (n + 1)
    dp[1], dp[2] = wine[1], wine[1] + wine[2]

    for i in range(3, n + 1):
        dp[i] = max(dp[i - 1], dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])

    result = dp[n]
    print(result)


if __name__ == "__main__":
    solve()
