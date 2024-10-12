from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    M = int(input())
    vip = [int(input()) for _ in range(M)]

    if N == 1:
        print(1)
        return

    dp = [1] * (N + 1)
    dp[2] = 2

    for i in range(3, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    prev, result = 0, 1
    for v in vip:
        result *= dp[v - prev - 1]
        prev = v
    result *= dp[N - prev]
    print(result)


if __name__ == "__main__":
    solve()
