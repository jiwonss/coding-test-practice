from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    dp = [0, 0, 1, 1]
    for x in range(4, N + 1):
        dp.append(dp[x - 1] + 1)
        if x % 2 == 0:
            dp[x] = min(dp[x], dp[x // 2] + 1)
        if x % 3 == 0:
            dp[x] = min(dp[x], dp[x // 3] + 1)
    print(dp[N])


if __name__ == "__main__":
    solve()
